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
				model.addAttribute("message", "Sai th??ng tin ????ng nh???p!");
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
			errors.rejectValue("username", "user", "Vui l??ng nh???p l???i username");
		} else if (!username.matches("^[a-z0-9_-]{6,12}$")) {
			errors.rejectValue("username", "user",
					"Username t??? 6 ?????n 12 k?? t???, kh??ng c?? k?? t??? kho???ng tr???ng, kh??ng c?? k?? t??? ?????c bi???t");
		} else if (userServiceImpl.get(username) != null) {

			errors.rejectValue("username", "user", "Username n??y ???? t???n t???i!");
		}
		if (user.getPassword() == null) {
			errors.rejectValue("password", "user", "Vui l??ng nh???p password!");
		} else if (!user.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$")) {
			errors.rejectValue("password", "user", "Password kh??ng ????ng ?????nh d???ng!");
		}
		if (user.getRePassword() == null) {
			errors.rejectValue("rePassword", "user", "Vui l??ng nh???p re-password!");
		} else if (!user.getRePassword().equals(user.getPassword())) {
			errors.rejectValue("rePassword", "user", "Re-password kh??ng kh???p v???i  password!");
		}
		if (user.getFullname() == null) {
			errors.rejectValue("fullname", "user", "Vui l??ng nh???p fullname!");
		}
		if (user.getEmail() == null) {
			errors.rejectValue("email", "user", "Vui l??ng nh???p email!");
		} else if (!user.getEmail().matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
			errors.rejectValue("email", "user", "Vui l??ng nh???p ????ng ?????nh d???ng  email!");
		}
		if (user.getPhone() == null) {
			errors.rejectValue("phone", "user", "Vui l??ng nh???p  phone!");
		} else if (user.getPhone().trim().length() == 0) {
			errors.rejectValue("phone", "user", "Vui l??ng nh???p phone!");
		} else if (!user.getPhone().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
			errors.rejectValue("phone", "user", "Vui l??ng nh???p ????ng ?????nh d???ng phone!");
		}
		if (errors.hasErrors()) {
			request.setAttribute("message", "Vui l??ng nh???p ????ng th??ng tin t??i kho???n!");
			model.addAttribute("userR", user);
		} else {
			System.out.println(user.getPassword() + "1");
			String hashPass = getMD5(user.getPassword().trim());
			user.setPassword(hashPass);
			boolean check = userServiceImpl.register(user);
			if (check) {
				request.setAttribute("message", "T???o t??i kho???n th??nh c??ng");
				

			} else {

				request.setAttribute("message", "T???o t??i kho???n th???t b???i");
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
			errors.rejectValue("fullname", "updateAccount", "Vui l??ng nh???p h??? v?? t??n!");
		} else if (fullname.trim().length() == 0) {
			errors.rejectValue("fullname", "updateAccount", "Vui l??ng nh???p h??? v?? t??n!");
		}
		if (phone == null) {
			errors.rejectValue("phone", "updateAccount", "Vui l??ng nh???p s??? ??i???n tho???i!");
		} else if (phone.trim().length() == 0) {
			errors.rejectValue("phone", "updateAccount", "Vui l??ng nh???p s??? ??i???n tho???i!");
		} else if (!phone.trim().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
			errors.rejectValue("phone", "updateAccount", "Vui l??ng nh???p ????ng ?????nh d???ng s??? ??i???n tho???i!");
			System.out.println("Khong dung dinh dang phone");
		}
		if (email == null) {
			errors.rejectValue("email", "updateAccount", "Vui l??ng nh???p email!");
		} else if (email.trim().length() == 0) {
			errors.rejectValue("email", "updateAccount", "Vui l??ng nh???p email!");
		} else if (!email.trim().matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
			errors.rejectValue("email", "updateAccount", "Vui l??ng nh???p ????ng ?????nh d???ng email!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("msg", "Vui l??ng nh???p ????ng ?????nh d???ng th??ng tin mu???n c???p nh???t!!!");
		} else {

			User newUser = userServiceImpl.get(username);
			newUser.setFullname(fullname);
			newUser.setEmail(email);
			newUser.setPhone(phone);
			boolean check = userServiceImpl.edit(newUser);
			if (check) {

				session.removeAttribute("userLogined");
				session.setAttribute("userLogined", newUser);
				model.addAttribute("msg", "C???p nh???t th??ng tin th??nh c??ng!");
			} else {
				model.addAttribute("msg", "C???p nh???t th??ng tin kh??ng th??nh c??ng!");
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
			errors.rejectValue("reNewpass", "changePassword", "Vui l??ng nh???p password m???i!");
		} else if (reNewPass.trim().length() == 0) {
			errors.rejectValue("reNewpass", "changePassword", "Vui l??ng nh???p password m???i!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("msg", "Vui l??ng nh???p ????ng ?????nh d???ng th??ng tin");
		} else {
			if (oldPass.trim().equals(user.getPassword().trim())) {

				if (newPass.trim().equals(reNewPass.trim())) {
					String hashPass = getMD5(reNewPass.trim());
					user.setPassword(hashPass);
					userServiceImpl.edit(user);
					model.addAttribute("msg", "??????????????????????????i m???t kh???u th??nh c??ng");
				} else {
					model.addAttribute("msg", "Nh???p l???i m???t kh???u m???i sai");
				}
			} else {
				model.addAttribute("msg", "Nh???p nh???t kh???u c?? sai");
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
		model.addAttribute("msg", "????n h??ng c?? m?? " + idOrdered + " ???? h???y th??nh c??ng");
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
