package shoplap.controller.admin;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dto.ChangePassword;
import shoplap.entity.Admin;
import shoplap.entity.User;
import shoplap.service.AdminService;
import shoplap.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminAccountController {
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

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String viewAdminList(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Admin> list = adminServiceImpl.getAll();
			int totalItem = list.size();
			int totalPage = list.size() % 6 == 0 ? (list.size() / 6) : (int) (list.size() / 6 + 1);
			int page = Integer.valueOf(request.getParameter("page"));
			int start = (page - 1) * 6;
			List<Admin> listShow = new ArrayList<Admin>();
			for (int i = start; i < start + 6; i++) {
				if (i == list.size()) {
					break;
				}
				listShow.add(list.get(i));
			}
			String message = request.getParameter("message");

			model.addAttribute("message", message);

			model.addAttribute("admins", listShow);
			model.addAttribute("page", page);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("totalItem", totalItem);
			model.addAttribute("countItem", (totalItem < 6) ? totalItem : 6);
			return "admin/admin_list";
		}
		return "error";
	}

	@RequestMapping(value = "admin/insert", method = RequestMethod.GET)
	public String insertUser(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			return "admin/admin_form";
		}
		return "error";
	}

	@RequestMapping(value = "admin/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("rePassword");
			String fullname = request.getParameter("fullname");

			System.out.println("username " + username);
			System.out.println("password " + password);
			System.out.println("fullname " + fullname);
			System.out.println("re " + rePassword);
//			System.out.println("mail " + mail);
//			System.out.println("phone " + phone);
			if (username.equals("") || password.equals("") || rePassword.equals("") || fullname.equals("")) {
				model.addAttribute("message", "Nh???p thi???u th??ng tin!");
			} else if (!rePassword.equals(password)) {
				model.addAttribute("message", "Nh???p l???i m???t kh???u kh??ng kh???p!");
			} else {
				String hashPass = getMD5(rePassword.trim());
				Admin admin = new Admin(username, hashPass, fullname);
				boolean check = adminServiceImpl.insert(admin);
				if (check) {
					model.addAttribute("message", "Th??m m???i th??nh c??ng!");
				} else {
					model.addAttribute("message", "Th??m m???i th???t b???i!");
				}
			}

			return "admin/admin_form";
		}
		return "error";
	}

	@RequestMapping(value = "change-password", method = RequestMethod.GET)
	public String changepassword(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			return "admin/change-password";
		}
		return "error";
	}

	@RequestMapping(value = "change-password", method = RequestMethod.POST)
	public String changepassword1(ModelMap model, HttpServletRequest request,
			@ModelAttribute("changePassword") ChangePassword changePassword, BindingResult errors) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String oldPass = request.getParameter("oldpass");
			String newPass = request.getParameter("newpass");
			String reNewPass = request.getParameter("reNewpass");

			Admin admin = adminServiceImpl.get(request.getParameter("username"));

			if (oldPass == null) {
				errors.rejectValue("oldPass", "changePassword", "Vui l??ng nh???p password c??!");
			} else if (oldPass.trim().length() == 0) {
				errors.rejectValue("oldPass", "changePassword", "Vui l??ng nh???p password c??!");
			}
			if (newPass == null) {
				errors.rejectValue("newPass", "changePassword", "Vui l??ng nh???p password m???i!");
			} else if (newPass.trim().length() == 0) {
				errors.rejectValue("newPass", "changePassword", "Vui l??ng nh???p password m???i!");
			}
			if (reNewPass == null) {
				errors.rejectValue("reNewpass", "changePassword", "Vui l??ng nh???p re-password m???i!");
			} else if (reNewPass.trim().length() == 0) {
				errors.rejectValue("reNewpass", "changePassword", "Vui l??ng nh???p re-password m???i!");
			}
			if (errors.hasErrors()) {
				model.addAttribute("msg", "Vui l??ng nh???p ????ng ?????nh d???ng th??ng tin");
			} else {
				if (oldPass.trim().equals(admin.getPassword().trim())) {

					if (newPass.trim().equals(reNewPass.trim())) {
						String hashPass = getMD5(reNewPass.trim());

						admin.setPassword(hashPass);
						System.out.println("hash pass " + admin.getPassword());
						boolean check = adminServiceImpl.edit(admin);
						if (check) {
							model.addAttribute("msg", "?????i m???t kh???u th??nh c??ng");
						} else {
							model.addAttribute("msg", "?????i m???t kh???u kh??ng th??nh c??ng");
						}
					} else {
						model.addAttribute("msg", "Nh???p l???i m???t kh???u m???i sai!!");
					}
				} else {
					model.addAttribute("msg", "Nh???p m???t kh???u c?? sai!");
				}
			}

			return "admin/change-password";
		}
		return "error";
	}
}
