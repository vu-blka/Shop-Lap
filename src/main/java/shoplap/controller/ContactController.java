package shoplap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import shoplap.dao.impl.MessageDaoImpl;
import shoplap.entity.Contact;
import shoplap.entity.Message;
import shoplap.service.impl.ContactServiceImpl;

@Controller
public class ContactController {

	@Autowired
	JavaMailSender mailer;

	ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
	MessageDaoImpl messageDaoImpl = new MessageDaoImpl();

	@RequestMapping("contact")
	public String contact(ModelMap model, HttpServletRequest request) {
		Contact contact1 = contactServiceImpl.get(1);
		model.addAttribute("contact", contact1);
		model.addAttribute("messagePara", request.getParameter("messagePara"));
		return "contact";
	}

	@RequestMapping("contact/send")
	public RedirectView send(ModelMap model, HttpServletRequest request, @ModelAttribute("message") Message message,
			BindingResult errors) {
		String name = message.getName();
		String email = message.getEmail();
		String phone_number = message.getPhone();
		String msg_subject = message.getSubject();
		String msg = message.getMsg();
		//
		if (name == null) {
			errors.rejectValue("name", "message", "Vui lòng nhập name!");
		} else if (name.trim().length() == 0) {
			errors.rejectValue("name", "message", "Vui lòng nhập name!");
		}
		//
		if (email == null) {
			errors.rejectValue("email", "message", "Vui lòng nhập email!");
		} else if (email.trim().length() == 0) {
			errors.rejectValue("email", "message", "Vui lòng nhập email!");
		} else if (!email.matches("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$")) {
			errors.rejectValue("email", "user", "Vui lòng nhập đúng định dạng email!");
		}
		//
		if (phone_number == null) {
			errors.rejectValue("phone_number", "message", "Vui lòng nhập số điện thoại!");
		} else if (phone_number.trim().length() == 0) {
			errors.rejectValue("phone_number", "message", "Vui lòng nhập số điện thoại!");
		}
		//
		if (msg_subject == null) {
			errors.rejectValue("msg_subject", "message", "Vui lòng nhập message!");
		} else if (msg_subject.trim().length() == 0) {
			errors.rejectValue("msg_subject", "message", "Vui lòng nhập message!");
		}
		//
		if (msg == null) {
			errors.rejectValue("msg", "message", "Vui lòng nhập message!");
		} else if (msg.trim().length() == 0) {
			errors.rejectValue("msg", "message", "Vui lòng nhập message!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("messagePara", "Vui lòng nhập thông tin!!!");
			model.addAttribute("contact4", message);
		} else {
			try {
				MimeMessage mail = mailer.createMimeMessage();

				MimeMessageHelper helper = new MimeMessageHelper(mail);

				helper.setFrom(phone_number, phone_number);
				helper.setFrom(name, name);
				helper.setFrom(email, email);
				helper.setTo("n18dccn166@student.ptithcm.edu.vn");
				helper.setReplyTo(email, email);
				helper.setSubject(msg_subject);
				helper.setText(msg, true);

				mailer.send(mail);
				// seen =0 la chua doc

				long millis = System.currentTimeMillis();
				java.sql.Date date = new java.sql.Date(millis);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String now = df.format(date);
				boolean check = messageDaoImpl
						.insert(new Message("", name, email, phone_number, msg_subject, msg, "0", now));
				if (check) {
					model.addAttribute("messagePara", "Gửi email thành công");
				} else {
					model.addAttribute("messagePara", "Gửi email thất bại");
				}

			} catch (Exception e) {
				model.addAttribute("messagePara", "Gửi email thất bại");
			}
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/SHOPLAP/contact.htm");

		return redirectView;
	}

}
