package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.PaymentDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Category;
import shoplap.entity.Payment;
import shoplap.entity.Product;

@Controller
@RequestMapping("/admin/")
public class AdminPaymentController {
	PaymentDaoImpl paymentDaoImpl = new PaymentDaoImpl();

	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String viewBillList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Payment> list = paymentDaoImpl.getAll();
			model.addAttribute("payments", list);
			String message=request.getParameter("message");
			model.addAttribute("message", message);
			model.addAttribute("totalItem", list.size());
			return "admin/payment_list";
		}
		return "error";
	}

	@RequestMapping(value = "payment/insert", method = RequestMethod.GET)
	public String insertUser(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {

			return "admin/payment_form";
		}
		return "error";

	}

	@RequestMapping(value = "payment/insert", method = RequestMethod.POST)
	public String insertUser1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String method = request.getParameter("method");
			if (method.equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = paymentDaoImpl.insert(new Payment(0, method));
				if (check) {
					model.addAttribute("message", "Thêm thành công!");
				} else {
					model.addAttribute("message", "Thêm thất bại, Phương thức thanh toán này đã tồn tại!");
				}
			}
			return "admin/payment_form";
		}
		return "error";
	}

	@RequestMapping(value = "payment/update", method = RequestMethod.GET)
	public String editProduct(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Payment payment = paymentDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("payment", payment);

			return "admin/payment_update";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "payment/update", method = RequestMethod.POST)
	public String editProduct1(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			String method = request.getParameter("method");

			if (method.trim().equals("")) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				boolean check = paymentDaoImpl.update(new Payment(Integer.valueOf(id), method));
				if (check) {
					model.addAttribute("message", "Chỉnh sửa thành công!");
				} else {
					model.addAttribute("message", "Chỉnh sửa thất bại!");
				}
			}
			Payment payment = paymentDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("payment", payment);

			return "admin/payment_update";
		} else {
			return "error";
		}
	}

	@RequestMapping("payment/remove.htm")
	public String deleteProduct(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean check = paymentDaoImpl.delete(Integer.valueOf(id));
		if (check) {
			model.addAttribute("message", "Xóa thành công!");
		} else {
			model.addAttribute("message", "Xóa thất bại!");
		}
		return "redirect:/admin/payment.htm";
	}
}
