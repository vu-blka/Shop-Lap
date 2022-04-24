package shoplap.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import shoplap.dao.impl.OrderedDaoImpl;
import shoplap.dto.ChangePassword;
import shoplap.dto.UpdateAccount;
import shoplap.entity.User;
import shoplap.service.impl.AddToCartServiceImpl;
import shoplap.service.impl.UserServiceImpl;

import shoplap.entity.Ordered;

@Controller
@RequestMapping("/user")
@SessionAttributes("userLogined")
public class UserController {
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	AddToCartServiceImpl addToCartServiceImpl = new AddToCartServiceImpl();
	RedirectView redirectView = new RedirectView();

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

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", request.getParameter("message"));
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			return "redirect:/index.htm";
		}
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public RedirectView login1(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = getMD5(request.getParameter("password"));
		
		try {
			Boolean check = userServiceImpl.login(username, password);
			if (check) {
				HttpSession session = request.getSession();
				User userLogined = userServiceImpl.get(username);

				session.setAttribute("userLogined", userLogined);
				session.setAttribute("username", username);
				session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));
				if (request.getParameter("remember") != null) {
					Cookie ckUsername = new Cookie("username", username);
					ckUsername.setMaxAge(3600);
					response.addCookie(ckUsername);
					Cookie ckPassword = new Cookie("password", password);
					ckPassword.setMaxAge(3600);
					response.addCookie(ckPassword);
					System.out.println("remember me");
				}
				redirectView.setUrl("http://localhost:8080/SHOPLAP/index.htm");
				return redirectView;
			} else {
				model.addAttribute("message", "Sai thông tin đăng nhập!");
				redirectView.setUrl("http://localhost:8080/SHOPLAP/user/login.htm");
				return redirectView;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirectView;
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register1(ModelMap model, HttpServletRequest request, @ModelAttribute("user") User user,
			BindingResult errors) {
		String username = user.getUsername();

		if (username == null) {
			errors.rejectValue("username", "user", "Vui lòng nhập lại username");
		} else if (!username.matches("^[a-z0-9_-]{6,12}$")) {
			errors.rejectValue("username", "user",
					"Username từ 6 đến 12 kí tự, không có kí tự khoảng trắng, không có kí tự đặc biệt");
		} else if (userServiceImpl.get(username) != null) {

			errors.rejectValue("username", "user", "Username này đã tồn tại!");
		}
		if (user.getPassword() == null) {
			errors.rejectValue("password", "user", "Vui lòng nhập password!");
		} else if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$")) {
			errors.rejectValue("password", "user", "Password không đúng định dạng!");
		}
		if (user.getRePassword() == null) {
			errors.rejectValue("rePassword", "user", "Vui lòng nhập re-password!");
		} else if (!user.getRePassword().equals(user.getPassword())) {
			errors.rejectValue("rePassword", "user", "Re-password không khớp với  password!");
		}
		if (user.getFullname() == null) {
			errors.rejectValue("fullname", "user", "Vui lòng nhập fullname!");
		}
		if (user.getEmail() == null) {
			errors.rejectValue("email", "user", "Vui lòng nhập email!");
		} else if (!user.getEmail().matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
			errors.rejectValue("email", "user", "Vui lòng nhập đúng định dạng  email!");
		}
		if (user.getPhone() == null) {
			errors.rejectValue("phone", "user", "Vui lòng nhập  phone!");
		} else if (user.getPhone().trim().length() == 0) {
			errors.rejectValue("phone", "user", "Vui lòng nhập phone!");
		} else if (!user.getPhone().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
			errors.rejectValue("phone", "user", "Vui lòng nhập đúng định dạng phone!");
		}
		if (errors.hasErrors()) {
			request.setAttribute("message", "Vui lòng nhập đúng thông tin tài khoản!");
			model.addAttribute("userR", user);
		} else {
			System.out.println(user.getPassword() + "1");
			String hashPass = getMD5(user.getPassword().trim());
			user.setPassword(hashPass);
			boolean check = userServiceImpl.register(user);
			if (check) {
				request.setAttribute("message", "Tạo tài khoản thành công");
				

			} else {

				request.setAttribute("message", "Tạo tài khoản thất bại");
			}
		}

		return "register";
	}

	@RequestMapping("")
	public String myaccount(ModelMap model) {
		return "my-account";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.removeAttribute("username");
			session.removeAttribute("userLogined");
			session.removeAttribute("quantityInCart");
		}
		for (Cookie ck : req.getCookies()) {
			if (ck.getName().equalsIgnoreCase("username")) {
				ck.setMaxAge(0);
				res.addCookie(ck);
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				ck.setMaxAge(0);
				res.addCookie(ck);
			}
		}
		return "login";
	}

	@RequestMapping("my-account")
	public String myAccount(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		User user = userServiceImpl.get(username);
		model.addAttribute("user", user);
		model.addAttribute("msg", request.getParameter("msg"));

		return "my-account";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ModelMap model, HttpServletRequest request,
			@ModelAttribute("updateAccount") UpdateAccount updateAccount, BindingResult errors) {
		String fullname = updateAccount.getFullname();
		String phone = updateAccount.getPhone();
		String email = updateAccount.getEmail();
		System.out.println("fullname " + fullname + "!");
		System.out.println("phone " + phone + "!");
		System.out.println("email " + email + "!");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (fullname == null) {
			errors.rejectValue("fullname", "updateAccount", "Vui lòng nhập họ và tên!");
		} else if (fullname.trim().length() == 0) {
			errors.rejectValue("fullname", "updateAccount", "Vui lòng nhập họ và tên!");
		}
		if (phone == null) {
			errors.rejectValue("phone", "updateAccount", "Vui lòng nhập số điện thoại!");
		} else if (phone.trim().length() == 0) {
			errors.rejectValue("phone", "updateAccount", "Vui lòng nhập số điện thoại!");
		} else if (!phone.trim().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
			errors.rejectValue("phone", "updateAccount", "Vui lòng nhập đúng định dạng số điện thoại!");
			System.out.println("Khong dung dinh dang phone");
		}
		if (email == null) {
			errors.rejectValue("email", "updateAccount", "Vui lòng nhập email!");
		} else if (email.trim().length() == 0) {
			errors.rejectValue("email", "updateAccount", "Vui lòng nhập email!");
		} else if (!email.trim().matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
			errors.rejectValue("email", "updateAccount", "Vui lòng nhập đúng định dạng email!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("msg", "Vui lòng nhập đúng định dạng thông tin muốn cập nhật!!!");
		} else {

			User newUser = userServiceImpl.get(username);
			newUser.setFullname(fullname);
			newUser.setEmail(email);
			newUser.setPhone(phone);
			boolean check = userServiceImpl.edit(newUser);
			if (check) {

				session.removeAttribute("userLogined");
				session.setAttribute("userLogined", newUser);
				model.addAttribute("msg", "Cập nhật thông tin thành công!");
			} else {
				model.addAttribute("msg", "Cập nhật thông tin không thành công!");
			}
		}
		model.addAttribute("user", userServiceImpl.get(username));
		return "my-account";
	}

	@RequestMapping("change-password")
	public String changePassword0(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}

		model.addAttribute("msg", request.getParameter("msg"));

		return "change-password";
	}

	@RequestMapping(value = "change-password", method = RequestMethod.POST)
	public String changePassword(ModelMap model, HttpServletRequest request,
			@ModelAttribute("changePassword") ChangePassword changePassword, BindingResult errors) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User user = new User();
		user = userServiceImpl.get(username);

		String oldPass = request.getParameter("oldpass");
		String newPass = request.getParameter("newpass");
		String reNewPass = request.getParameter("reNewpass");
		if (oldPass == null) {
			errors.rejectValue("oldPass", "changePassword", "Vui lòng nhập password cũ!");
		} else if (oldPass.trim().length() == 0) {
			errors.rejectValue("oldPass", "changePassword", "Vui lòng nhập password cũ!");
		}
		if (newPass == null) {
			errors.rejectValue("newPass", "changePassword", "Vui lòng nhập password mới!");
		} else if (newPass.trim().length() == 0) {
			errors.rejectValue("newPass", "changePassword", "Vui lòng nhập password mới!");
		}
		if (reNewPass == null) {
			errors.rejectValue("reNewpass", "changePassword", "Vui lòng nhập password mới!");
		} else if (reNewPass.trim().length() == 0) {
			errors.rejectValue("reNewpass", "changePassword", "Vui lòng nhập password mới!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("msg", "Vui lòng nhập đúng định dạng thông tin");
		} else {
			if (oldPass.trim().equals(user.getPassword().trim())) {

				if (newPass.trim().equals(reNewPass.trim())) {
					String hashPass = getMD5(reNewPass.trim());
					user.setPassword(hashPass);
					userServiceImpl.edit(user);
					model.addAttribute("msg", "Ã„ï¿½Ã¡Â»â€¢i mật khẩu thành công");
				} else {
					model.addAttribute("msg", "Nhập lại mật khẩu mới sai");
				}
			} else {
				model.addAttribute("msg", "Nhập nhật khẩu cũ sai");
			}
		}

		return "change-password";
	}

	@RequestMapping(value = "ordered", method = RequestMethod.GET)
	public String ordered(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		OrderedDaoImpl orderedDaoImpl = new OrderedDaoImpl();
		List<Ordered> list = orderedDaoImpl.getNull();
		list.addAll(orderedDaoImpl.getNotNull());

		model.addAttribute("list", list);
		return "ordered";
	}

	@RequestMapping(value = "ordered/cancel", method = RequestMethod.GET)
	public String cancelOrdered(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		String idOrdered = request.getParameter("idOrdered");

		OrderedDaoImpl orderedDaoImpl = new OrderedDaoImpl();
		Ordered ordered = orderedDaoImpl.get(Integer.valueOf(idOrdered));
		ordered.setIdAdmin("0");
		boolean check = orderedDaoImpl.update(ordered);
		List<Ordered> list = orderedDaoImpl.getNull();
		list.addAll(orderedDaoImpl.getNotNull());
		model.addAttribute("msg", "Đơn hàng có mã " + idOrdered + " đã hủy thành công");
		model.addAttribute("list", list);
		return "ordered";
	}

	public User checkCookieUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		User user = null;
		String username = "", password = "";
		for (Cookie ck : cookies) {
			if (ck.getName().equalsIgnoreCase("username"))
				username = ck.getValue();
			if (ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
		}
		if (!username.isEmpty() && !password.isEmpty()) {
			user = userServiceImpl.get(username);

		}
		return user;

	}
}
