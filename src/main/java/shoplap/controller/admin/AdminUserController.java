package shoplap.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.UserDaoImpl;
import shoplap.entity.Product;
import shoplap.entity.User;

@Controller
@RequestMapping("/admin/")
public class AdminUserController {
	UserDaoImpl userDaoImpl = new UserDaoImpl();

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String viewUserList(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<User> list = userDaoImpl.getAll();
			int totalItem = list.size();
			int totalPage = list.size() % 6 == 0 ? (list.size() / 6) : (int) (list.size() / 6 + 1);
			int page = Integer.valueOf(request.getParameter("page"));
			int start = (page - 1) * 6;
			List<User> listShow = new ArrayList<User>();
			for (int i = start; i < start + 6; i++) {
				if (i == list.size()) {
					break;
				}
				listShow.add(list.get(i));
			}
			String message = request.getParameter("message");

			model.addAttribute("message", message);

			model.addAttribute("users", listShow);
			model.addAttribute("page", page);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("totalItem", totalItem);
			model.addAttribute("countItem", (totalItem < 6) ? totalItem : 6);
			return "admin/user_list";
		}
		return "error";
	}

//	@RequestMapping(value = "user/{page}", method = RequestMethod.GET)
//	public String viewUserListByPage(ModelMap model, @PathVariable("page") int page) {
//		model.addAttribute("listUser", userService.getAllUser((page - 1) * 10, 10));
//		model.addAttribute("page", userService.countRecord() / 10);
//		model.addAttribute("totalItem", userService.countRecord());
//		if ((page * 10) > userService.countRecord()) {
//			model.addAttribute("countItem", userService.countRecord() - (page - 1) * 10);
//		} else {
//			model.addAttribute("countItem", 10);
//		}
//		return "admin/user_list";
//	}
//
	@RequestMapping(value = "user/insert", method = RequestMethod.GET)
	public String insertUser(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			return "admin/user_form";
		}
		return "error";

	}

//
	@RequestMapping(value = "user/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("rePassword");
			String fullname = request.getParameter("fullname");
			String mail = request.getParameter("email");
			String phone = request.getParameter("phone");
//			System.out.println("username " + username);
//			System.out.println("password " + password);
//			System.out.println("fullname " + fullname);
//			System.out.println("re " + rePassword);
//			System.out.println("mail " + mail);
//			System.out.println("phone " + phone);
			if (username.equals("") || password.equals("") || rePassword.equals("") || fullname.equals("")
					|| mail.equals("") || phone.equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else if (!rePassword.equals(password)) {
				model.addAttribute("message", "Nhập lại mật khẩu không khớp!");
			} else {
				User user=new User(username, rePassword, fullname, phone, mail);
				boolean check = userDaoImpl.insert(user);
				if (check) {
					model.addAttribute("message", "Thêm mới thành công!");
				} else {
					model.addAttribute("message", "Thêm mới thất bại!");
				}
			}

			return "admin/user_form";
		}
		return "error";
	}
//
//	@RequestMapping(value = "user/update/{id}", method = RequestMethod.GET)
//	public String editUser(ModelMap model, @PathVariable("id") Long id) {
//		Session session = factory.openSession();
//		User user = (User) session.get(User.class, id);
//		model.addAttribute("user", user);
//		model.addAttribute("role", userService.getAllRole());
//		return "admin/user_update";
//	}
//
//	@RequestMapping(value = "user/update/{id}", method = RequestMethod.POST)
//	public String editUser(ModelMap model, @ModelAttribute("user") User user) {
//		boolean check = userService.updateUser(user);
//		if (check) {
//			model.addAttribute("message", "Cập nhật thành công!");
//		} else {
//			model.addAttribute("message", "Cập nhật thất bại!");
//		}
//		model.addAttribute("role", userService.getAllRole());
//		return "admin/user_update";
//	}
//
//	@RequestMapping("user/remove/{id}")
//	public String deleteUser(ModelMap model, @PathVariable("id") Long id) {
//		boolean check = userService.deleteUser(id);
//		if (check) {
//			model.addAttribute("message", "Xóa thành công!");
//		} else {
//			model.addAttribute("message", "Xóa thất bại!");
//		}
//		return "redirect:/admin/user.html";
//	}
}
