package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shoplap.dao.impl.OrderedDaoImpl;
import shoplap.dao.impl.OrderedItemDaoImpl;
import shoplap.entity.Admin;
import shoplap.entity.Bill;
import shoplap.entity.Ordered;
import shoplap.entity.OrderedItem;
import shoplap.service.BillService;
import shoplap.service.impl.BillServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminBillController {
	OrderedDaoImpl orderedDaoImpl = new OrderedDaoImpl();
	BillServiceImpl billServiceImp = new BillServiceImpl();
	OrderedItemDaoImpl orderedItemDaoImpl = new OrderedItemDaoImpl();

	@RequestMapping(value = "bill", method = RequestMethod.GET)
	public String viewBillList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String page = request.getParameter("page");
			List<Ordered> listNotNull = orderedDaoImpl.getNotNull();

			List<Ordered> listNull = orderedDaoImpl.getNull();
			;
			listNull.addAll(listNotNull);
			if (listNull.size() == 0) {
				model.addAttribute("message", "Không có dữ liệu!!");
			}
			model.addAttribute("listBill", listNull);
			for (int i = 0; i < listNull.size(); i++) {
				System.out.println("show " + listNull.get(i).getIdOrdered());
			}
			model.addAttribute("page", page);
			model.addAttribute("totalItem", listNotNull.size() + listNull.size());
			model.addAttribute("countItem", 10);
			return "admin/bill_list";
		}
		return "error";
	}

	@RequestMapping(value = "bill/detail", method = RequestMethod.GET)
	public String viewBillListByPage(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			System.out.println("id " + id);
			model.addAttribute("id", id);
			Ordered ordered = orderedDaoImpl.get(Integer.valueOf(id));

			if (ordered.getIdAdmin() == null) {
				ordered.setIdAdmin("");
			}

			model.addAttribute("ordered", ordered);
			Bill bill = billServiceImp.get(ordered.getIdBill());
			model.addAttribute("bill", bill);
			List<OrderedItem> listOrderedItem = billServiceImp.getOrderedItemInBill(ordered.getIdOrdered());
			System.out.println("size " + listOrderedItem.size());
			model.addAttribute("listOrderedItem", listOrderedItem);

			return "admin/bill_detail";
		}
		return "error";
	}

//	@RequestMapping(value = "bill/detail/{id}", method = RequestMethod.GET)
//	public String editBill(ModelMap model, @PathVariable("id") int idBill) {
//		List<BillDetail> list = billService.getBillDetail(idBill);
//		model.addAttribute("listBillDetail", list);
//		model.addAttribute("bill", billService.getOneBill(idBill));
//		return "admin/billdetail_form";
//	}
//
//	@RequestMapping(value = "bill/detail/{id}", method = RequestMethod.POST)
//	public String editBill(ModelMap model, @ModelAttribute("billDetail") BillDetail billDetail) {
////		boolean check = billService.updateProduct(billDetail);
////		if(check) {
////			model.addAttribute("message","Cáº­p nháº­t thÃ nh cÃ´ng!");
////		}else {
////			model.addAttribute("message","Cáº­p nháº­t tháº¥t báº¡i!");
////		}
//		return "admin/billdetail_form";
//	}
//
	@RequestMapping("bill/update")
	public String updateBillStatus(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			model.addAttribute("id", id);
			Ordered ordered = orderedDaoImpl.get(Integer.valueOf(id));
			Admin admin = (Admin) session.getAttribute("adminsession");
			ordered.setIdAdmin(admin.getUsername());
			boolean check = orderedDaoImpl.update(ordered);
			if (check) {
				model.addAttribute("message", "Đã duyệt thành công!");
			} else {
				model.addAttribute("message", "Đã duyệt thất bại!");
			}
			List<Ordered> list = orderedDaoImpl.getNull();

			session.setAttribute("size", list.size());
			session.setAttribute("listNull", list);
			return "redirect:/admin/bill.htm";
		}
		return "error";
	}
//
//	@RequestMapping("bill/remove/{id}")
//	public String deleteBillStatus(ModelMap model, @PathVariable("id") int id) {
//		boolean check = billService.removeBill(id);
//		if (check) {
//			model.addAttribute("message", "Há»§y Ä‘Æ¡n hÃ ng thÃ nh cÃ´ng!");
//		} else {
//			model.addAttribute("message", "Há»§y Ä‘Æ¡n hÃ ng tháº¥t báº¡i!");
//		}
//		return "redirect:/admin/bill.html";
//	}

}
