package shoplap.controller.admin;

//
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.ShippingDaoImpl;
import shoplap.entity.Shipping;

//
@Controller
@RequestMapping("/admin/")
public class AdminShippingController {
	ShippingDaoImpl shippingDaoImpl = new ShippingDaoImpl();

//
	@RequestMapping(value = "shipping", method = RequestMethod.GET)
	public String viewBillList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Shipping> list = shippingDaoImpl.getAll();
			model.addAttribute("shippings", list);
			String message = request.getParameter("message");
			model.addAttribute("message", message);
			model.addAttribute("countItem", list.size());
			return "admin/shipping_list";
		}
		return "error";
	}

//
	@RequestMapping(value = "shipping/insert", method = RequestMethod.GET)
	public String insertUser(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {

			return "admin/shipping_form";
		}
		return "error";

	}

//
	@RequestMapping(value = "shipping/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String method = request.getParameter("method");
			String fee = request.getParameter("fee");

			if (method.equals("") || fee.equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = shippingDaoImpl.insert(new Shipping(0, method, Integer.valueOf(fee)));
				if (check) {
					model.addAttribute("message", "Thêm thành công!");
				} else {
					model.addAttribute("message", "Thêm thất bại, Hãng vận chuyển này đã tồn tại!");
				}
			}
			return "admin/shipping_form";
		}
		return "error";
	}

//
	@RequestMapping(value = "shipping/update", method = RequestMethod.GET)
	public String editProduct(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Shipping shipping = shippingDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("shipping", shipping);

			return "admin/shipping_update";
		} else {
			return "error";
		}
	}

//
	@RequestMapping(value = "shipping/update", method = RequestMethod.POST)
	public String editProduct1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			String method = request.getParameter("method");
			String fee = request.getParameter("fee");
			if (method.trim().equals("") || fee.trim().equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = shippingDaoImpl.update(new Shipping(Integer.valueOf(id), method,Integer.valueOf(fee)));
				if (check) {
					model.addAttribute("message", "Chỉnh sửa thành công!");
				} else {
					model.addAttribute("message", "Chỉnh sửa thất bại!");
				}
			}
			Shipping shipping = shippingDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("shipping", shipping);

			return "admin/shipping_update";
		} else {
			return "error";
		}
	}
//
	@RequestMapping("shipping/remove.htm")
	public String deleteProduct(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean check = shippingDaoImpl.delete(Integer.valueOf(id));
		if (check) {
			model.addAttribute("message", "Xóa thành công!");
		} else {
			model.addAttribute("message", "Xóa thất bại!");
		}
		return "redirect:/admin/shipping.htm";
	}
}
