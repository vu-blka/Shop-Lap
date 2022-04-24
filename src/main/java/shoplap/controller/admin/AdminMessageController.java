package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import shoplap.dao.impl.MessageDaoImpl;
import shoplap.entity.Message;

@Controller
@RequestMapping("admin/message")
public class AdminMessageController {
	MessageDaoImpl messageDaoImpl = new MessageDaoImpl();

	@RequestMapping("")
	public String index(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Message> list = messageDaoImpl.getUnSeen();
			list.addAll(messageDaoImpl.getSeen());
			model.addAttribute("messages", list);
			model.addAttribute("totalItem", list.size());
			return "admin/message_list";
		}
		return "error";
	}

	@RequestMapping("detail")
	public String detail(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Message message = messageDaoImpl.get(id);
			model.addAttribute("message", message);
			model.addAttribute("seen", Integer.valueOf(message.getSeen()));
			return "admin/message_detail";
		}
		return "error";
	}

	@RequestMapping("update")
	public String update(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			boolean check = messageDaoImpl.update(id);
			if (check) {
				model.addAttribute("messageF", "Đã đánh dấu đã đọc!!!");
				List<Message> list1 = messageDaoImpl.getUnSeen();
				session.setAttribute("listMessage", list1);
				session.setAttribute("sizeMessage", list1.size());
			} else {
				model.addAttribute("messageF", "Đánh dấu đã đọc thất bại!!!");
			}
			Message message = messageDaoImpl.get(id);
			model.addAttribute("message", message);
			model.addAttribute("seen", Integer.valueOf(message.getSeen()));

			return "admin/message_detail";
		}
		return "error";
	}
}
