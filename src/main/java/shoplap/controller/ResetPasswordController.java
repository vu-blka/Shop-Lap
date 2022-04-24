package shoplap.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.UserDaoImpl;
import shoplap.dto.ResetPassword;
import shoplap.entity.User;
import shoplap.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user/")
public class ResetPasswordController {
	@Autowired
	JavaMailSender mailer;

	UserServiceImpl userServiceImpl = new UserServiceImpl();

	public static String convertByteToHex(byte[] data) {
		BigInteger number = new BigInteger(1, data);
		String hashtext = number.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			return convertByteToHex(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping(value = "reset-password", method = RequestMethod.GET)
	public String get() {
		return "reset-password";
	}

	@RequestMapping(value = "reset-password", method = RequestMethod.POST)
	public String resetPassword(ModelMap model, HttpServletRequest request,
			@ModelAttribute("resetPassword") ResetPassword resetPassword, BindingResult errors) {
		String username = resetPassword.getUsername();
		if (username == null) {
			errors.rejectValue("username", "resetPassword", "Vui lòng nhập username!");
		} else if (username.trim().length() == 0) {
			errors.rejectValue("username", "resetPassword", "Vui lòng nhập username!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng nhập đúng thông tin!");
		} else {
			User newuser = new User();
			newuser = userServiceImpl.get(username);
			if (newuser == null) {
				model.addAttribute("message", "Username +" + username + " không tồn tại!");

			} else {
				model.addAttribute("usernameR", newuser.getUsername().trim());
			}
		}
		return "reset-password";
	}

	@RequestMapping(value = "confirm-mail-reset-password", method = RequestMethod.POST)
	public String resetPassword1(ModelMap model, HttpServletRequest request,
			@ModelAttribute("resetPassword") ResetPassword resetPassword, BindingResult errors) {
		String username = resetPassword.getUsername();
		String cmail = resetPassword.getCmail();
		User newuser = new User();
		newuser = userServiceImpl.get(username);
		if (cmail == null) {
			errors.rejectValue("cmail", "resetPassword", "Vui lòng xác nhận mail!");
		} else if (cmail.trim().length() == 0) {
			errors.rejectValue("cmail", "resetPassword", "Vui lòng xác nhận mail!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng nhập đủ thông tin!");
			model.addAttribute("usernameR", username);
		} else {
			if (!cmail.trim().equals(newuser.getEmail().trim())) {
				model.addAttribute("message", "Mail không khớp!");
			} else {
				try {
					MimeMessage mail = mailer.createMimeMessage();

					MimeMessageHelper helper = new MimeMessageHelper(mail);

					helper.setFrom("ponpham113@gmail.com", "ponpham113@gmail.com");
					helper.setTo(newuser.getEmail());
					helper.setSubject("mat khau moi cua ban");
					helper.setReplyTo("ponpham113@gmail.com", "ponpham113@gmail.com");

					//
					String digits = "0123456789";

					String alpha = "abcdefghijklmnopqrstuvwxyz";
					String alphaUpperCase = alpha.toUpperCase();
					String ALL = alpha + alphaUpperCase + digits;

					List<String> result = new ArrayList<>();
					Random generator = new Random();
					Consumer<String> appendChar = s -> {
						int number = generator.nextInt(s.length());
						result.add("" + s.charAt(number));
					};
					appendChar.accept(digits);

					while (result.size() < 6) {
						appendChar.accept(ALL);
					}
					Collections.shuffle(result, generator);
					String newpassword = String.join("", result);

					//

					newuser.setPassword(getMD5(newpassword));
					userServiceImpl.edit(newuser);
					helper.setText("Tài khoản của bạn là: " + username + " | mật khẩu của bạn là: " + newpassword,
							true);

					mailer.send(mail);
					model.addAttribute("message", "Mật khẩu mới đã được gởi vào mail!!");

				} catch (Exception e) {
					model.addAttribute("message", "Đổi mật khẩu thất bại!");
				}
			}
		}

		return "reset-password";
	}
}
