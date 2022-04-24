package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.CategoryDaoImpl;
import shoplap.dto.LoginRequest;
import shoplap.entity.Category;
import shoplap.entity.Payment;

@Controller
@RequestMapping("/admin/")
public class AdminCategoryController {
//
//	@Autowired
//	CategoryService categoryService;
//
//	@Autowired
//	SessionFactory factory;
//
//	@Autowired
//	HttpSession session;
	CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();

	@RequestMapping("category")
	public String category(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Category> listCategory = categoryDaoImpl.getAll();
			model.addAttribute("listCategory", listCategory);
			model.addAttribute("totalItem", listCategory.size());
			model.addAttribute("message", request.getParameter("message"));
			return "admin/category_list";
		}
		return "error";
	}

	@RequestMapping(value = "category/insert", method = RequestMethod.GET)
	public String category_form(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			return "admin/category_form";
		}
		return "error";
	}

	@RequestMapping(value = "category/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String category = request.getParameter("category");
			String id = request.getParameter("id");
			if (category.trim().equals("") || id.trim().equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = categoryDaoImpl.insert(new Category(id, category));
				if (check) {
					model.addAttribute("message", "Thêm thành công!");
				} else {
					model.addAttribute("message", "Thêm thất bại!");
				}
			}
			return "admin/category_form";
		}
		return "error";
	}

//
	@RequestMapping(value = "category/update", method = RequestMethod.GET)
	public String edit(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			model.addAttribute("category", categoryDaoImpl.get(id));
			return "admin/category_update";
		}
		return "error";
	}

//
	@RequestMapping(value = "category/update", method = RequestMethod.POST)
	public String edit1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			String category = request.getParameter("category");

			if (id.trim().equals("") || category.trim().equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = categoryDaoImpl.edit(new Category(id, category));
				if (check) {
					model.addAttribute("message", "Chỉnh sửa thành công!");
				} else {
					model.addAttribute("message", "Chỉnh sửa thất bại!");
				}
			}

			model.addAttribute("category", categoryDaoImpl.get(id));

			return "admin/category_update";
		} else {
			return "error";
		}
	}

//
	@RequestMapping("category/remove")
	public String delete(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			boolean check = categoryDaoImpl.delete(id);
			if (check) {
				model.addAttribute("message", "Xóa thành công!");
			} else {
				model.addAttribute("message", "Xóa thất bại!");
			}
			return "redirect:/admin/category.htm";
		}
		return "error";

	}
}
