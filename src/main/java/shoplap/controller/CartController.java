package shoplap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import shoplap.dao.impl.CartDaoImpl;
import shoplap.dao.impl.PaymentDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.dao.impl.ShippingDaoImpl;
import shoplap.entity.Bill;
import shoplap.entity.Cart;
import shoplap.entity.Ordered;
import shoplap.entity.Payment;
import shoplap.entity.Product;
import shoplap.entity.Shipping;
import shoplap.service.CheckoutService;
import shoplap.service.impl.AddToCartServiceImpl;
import shoplap.service.impl.BillServiceImpl;
import shoplap.service.impl.CheckoutServiceImpl;
import shoplap.service.impl.OrderedServiceImpl;
import shoplap.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")

public class CartController {
	AddToCartServiceImpl addToCartServiceImpl = new AddToCartServiceImpl();
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	RedirectView redirectView = new RedirectView();
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	CheckoutServiceImpl checkoutServiceImpl = new CheckoutServiceImpl();
	BillServiceImpl billServiceImpl = new BillServiceImpl();
	ShippingDaoImpl shippingDaoImpl = new ShippingDaoImpl();
	PaymentDaoImpl paymentDaoImpl = new PaymentDaoImpl();
	OrderedServiceImpl orderedServiceImpl = new OrderedServiceImpl();

	@RequestMapping("cart")
	public String cart(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		List<Cart> list = userServiceImpl.getCartsByUsername(username);
		for (int i = 0; i < list.size(); i++) {
			addToCartServiceImpl.updateCart(list.get(i));
		}
		int subtotal = 0;
		int sale = 0;
		for (Cart element : list) {
			subtotal += element.getProduct().getPrice() * element.getQuantity();
			sale += (int) element.getProduct().getPrice() * element.getProduct().getSale() / 100
					* element.getQuantity();

		}
		model.addAttribute("total", subtotal - sale);
		model.addAttribute("sale", sale);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("listCart", list);
		session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));
		model.addAttribute("message", request.getParameter("message"));
		return "cart";
	}

	@RequestMapping(value = "add-to-cart")
	public RedirectView cart1(ModelMap model, HttpServletRequest request) {
		int quantity = 1;
		if (request.getParameter("quantity") != null) {
			quantity = Integer.valueOf(request.getParameter("quantity"));
		}
		HttpSession session = request.getSession();
		try {
			String username = (String) session.getAttribute("username");
			if (username == null) {
				redirectView.setUrl("http://localhost:8080/SHOPLAP/user/login.htm");
				return redirectView;
			}
			String idProduct = request.getParameter("id");
			Cart cart = new Cart(productDaoImpl.get(Integer.valueOf(idProduct)), username, quantity);
			addToCartServiceImpl.addToCart(cart);
			session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));

			redirectView.setUrl("http://localhost:8080/SHOPLAP/index.htm");
			session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));
			return redirectView;
		} catch (Exception e) {
			// TODO: handle exception

			redirectView.setUrl("http://localhost:8080/SHOPLAP/user/login.htm");
			return redirectView;
		}
	}

	@RequestMapping("cart/delete")
	public RedirectView delete(ModelMap model, HttpServletRequest request) {
		String idProductDelete = request.getParameter("delete");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		cartDaoImpl.delete(cartDaoImpl.get(Integer.valueOf(idProductDelete), username));
		model.addAttribute("message", "Xóa thành công product!");
		redirectView.setUrl("http://localhost:8080/SHOPLAP/user/cart.htm");
		session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));
		return redirectView;
	}

	@RequestMapping(value = "cart/update-cart")
	public RedirectView update(ModelMap model, HttpServletRequest request) {
		String idProduct = request.getParameter("id");
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		if (quantity < 0) {
			model.addAttribute("message", "Quantity: " + quantity + " - Số lượng không phù hợp!");
			redirectView.setUrl("http://localhost:8080/SHOPLAP/user/cart.htm");
		} else if (quantity == 0) {
			redirectView.setUrl("http://localhost:8080/SHOPLAP/user/cart/delete.htm?delete=" + idProduct);

		} else {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			Product product = new Product();
			product.setId(Integer.valueOf(idProduct));
			Cart cart = new Cart(product, username, quantity);

			addToCartServiceImpl.updateCart(cart);
			model.addAttribute("message", "Quantity: " + quantity + " - Update thành công!");
			session.setAttribute("quantityInCart", addToCartServiceImpl.show(username));
			redirectView.setUrl("http://localhost:8080/SHOPLAP/user/cart.htm");
		}

		return redirectView;
	}

	@RequestMapping("cart/checkout")
	public String checkout(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		model.addAttribute("listShipping", getShippings());
		model.addAttribute("listPayment", getPayments());
		model.addAttribute("subtotal", request.getParameter("subtotal"));
		model.addAttribute("total", request.getParameter("total"));
		model.addAttribute("sale", request.getParameter("sale"));
		return "checkout";
	}

	@RequestMapping("cart/confirm-checkout")
	public String confirmCheckout(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		int idPayment = Integer.valueOf(request.getParameter("payment"));
		String note = request.getParameter("notes");
		int idShipping = Integer.valueOf(request.getParameter("shipping"));
		int subtotal = Integer.valueOf(request.getParameter("subtotal"));
		int sale = Integer.valueOf(request.getParameter("sale"));
		Payment payment = paymentDaoImpl.get(idPayment);

		Shipping shipping = shippingDaoImpl.get(idShipping);
		String money = String.valueOf(subtotal - sale + shipping.getFee());

		long millis = System.currentTimeMillis();
		java.sql.Date today = new java.sql.Date(millis);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(today);
		int idBill = billServiceImpl.count() + 1;
		Bill bill = new Bill(idBill, username, fullname, phone, mail, address, note, payment, money, date, shipping);
		billServiceImpl.insert(bill);

		model.addAttribute("subtotal", subtotal);
		model.addAttribute("sale", sale);
		model.addAttribute("feeShipping", shipping.getFee());
		model.addAttribute("bill", bill);
		return "confirm-checkout";
	}

	@RequestMapping("cart/success")
	public String success(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		}
		List<Cart> list = userServiceImpl.getCartsByUsername(username);
		for (int i = 0; i < list.size(); i++) {
			addToCartServiceImpl.updateCart(list.get(i));
		}
		list = userServiceImpl.getCartsByUsername(username);

		String idBill = request.getParameter("idBill");

		Bill bill = billServiceImpl.get(Integer.valueOf(idBill));

		int idBillNew = billServiceImpl.count() + 1;
		if (idBillNew != Integer.valueOf(idBill)) {
			bill = new Bill(idBillNew, bill.getUsername(), bill.getFullname(), bill.getPhone(), bill.getMail(),
					bill.getAddress(), bill.getNote(), bill.getPayment(), bill.getMoney(), bill.getDate(),
					bill.getShipping());
		}
		billServiceImpl.insert(bill);
		int idOrdered = orderedServiceImpl.count() + 1;
		Ordered ordered = new Ordered(idOrdered, "", Integer.valueOf(idBill), list);
		orderedServiceImpl.insert(ordered, username);
		for (int i = 0; i < list.size(); i++) {
			Cart cart = list.get(i);
			orderedServiceImpl.insertOrderedItem(cart.getProduct().getId(), idOrdered, cart.getQuantity());
		}
		for (int i = 0; i < list.size(); i++) {
			addToCartServiceImpl.delete(list.get(i));
		}

		return "success";
	}

	@ModelAttribute("listShipping")
	public List<Shipping> getShippings() {
		List<Shipping> list = checkoutServiceImpl.getAllShipping();
		return list;
	}

	@ModelAttribute("listPayment")
	public List<Payment> getPayments() {
		List<Payment> list = checkoutServiceImpl.getAllPayment();
		return list;
	}
}
