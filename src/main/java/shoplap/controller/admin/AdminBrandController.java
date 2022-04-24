package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.BrandDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Payment;

@Controller
@RequestMapping("/admin/")
public class AdminBrandController {
	BrandDaoImpl brandDaoImpl = new BrandDaoImpl();

	@RequestMapping(value = "brand", method = RequestMethod.GET)
	public String viewBillList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Brand> list = brandDaoImpl.getAll();
			model.addAttribute("brands", list);
			String message = request.getParameter("message");
			model.addAttribute("message", message);
			model.addAttribute("totalItem", list.size());
			return "admin/brand_list";
		}
		return "error";
	}

	@RequestMapping(value = "brand/insert", method = RequestMethod.GET)
	public String insertUser(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {

			return "admin/brand_form";
		}
		return "error";

	}

	@RequestMapping(value = "brand/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String brand = request.getParameter("brand");
			String img=request.getParameter("photo");
			if (brand.equals("")||img.equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = brandDaoImpl.insert(new Brand(0, brand,img));
				if (check) {
					model.addAttribute("message", "Thêm thành công!");
				} else {
					model.addAttribute("message", "Thêm thất bại!");
				}
			}
			return "admin/brand_form";
		}
		return "error";
	}

	@RequestMapping(value = "brand/update", method = RequestMethod.GET)
	public String editProduct(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Brand brand = brandDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("brand", brand);

			return "admin/brand_update";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "brand/update", method = RequestMethod.POST)
	public String editProduct1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			String brand = request.getParameter("brand");
			Brand brand1=brandDaoImpl.get(Integer.valueOf(id));
			
			String photo="";
			if(request.getParameter("photo").trim().equals("")) {
				 photo+=brand1.getImg();
			}
			else {
				 photo+=request.getParameter("photo");
			}
					
			if (brand.trim().equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = brandDaoImpl.edit(new Brand(Integer.valueOf(id), brand,photo));
				if (check) {
					model.addAttribute("message", "Chỉnh sửa thành công!");
				} else {
					model.addAttribute("message", "Chỉnh sửa thất bại!");
				}
			}

			model.addAttribute("brand", brandDaoImpl.get(Integer.valueOf(id)));

			return "admin/brand_update";
		} else {
			return "error";
		}
	}

	@RequestMapping("brand/remove.htm")
	public String deleteProduct(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean check = brandDaoImpl.delete(Integer.valueOf(id));
		if (check) {
			model.addAttribute("message", "Xóa thành công!");
		} else {
			model.addAttribute("message", "Xóa thất bại!");
		}
		return "redirect:/admin/brand.htm";
	}

}
