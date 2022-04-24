package shoplap.controller.admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.MessageDaoImpl;
import shoplap.dao.impl.OrderedDaoImpl;
import shoplap.dto.LoginRequest;
import shoplap.entity.Admin;
import shoplap.entity.Message;
import shoplap.entity.Ordered;
import shoplap.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminAccessController {

	@Autowired
	HttpSession session;

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

	AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	OrderedDaoImpl orderedDaoImpl = new OrderedDaoImpl();
	MessageDaoImpl messageDaoImpl = new MessageDaoImpl();

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String signInAdmin(ModelMap model) {
		model.addAttribute("loginRequest", new LoginRequest());
		return "admin/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String signInAdmin(ModelMap model, @ModelAttribute("loginRequest") LoginRequest loginRequest) {
		String hashPass = getMD5(loginRequest.getPassword().trim());
		loginRequest.setPassword(hashPass);
		Admin admin = adminServiceImpl.checkLoginAdmin(loginRequest.getUsername(), loginRequest.getPassword());

		if (admin == null) {
			model.addAttribute("message", "Vui lòng kiểm tra lại tài khoản và mật khẩu!");
			return "admin/login";
		}
		session.setAttribute("adminsession", admin);
		List<Ordered> list = orderedDaoImpl.getNull();
		List<Message> list1 = messageDaoImpl.getUnSeen();
		session.setAttribute("size", list.size());
		session.setAttribute("listNull", list);
		session.setAttribute("listMessage", list1);
		session.setAttribute("sizeMessage", list1.size());
		return "redirect:/admin/index.htm";
	}

//	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutAdmin(ModelMap model) {
		session.invalidate();
		return "redirect:/admin/login.htm";
	}
}
