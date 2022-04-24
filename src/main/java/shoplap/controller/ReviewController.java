package shoplap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import shoplap.dao.impl.ProductDaoImpl;
import shoplap.dao.impl.ReviewDaoImpl;
import shoplap.entity.Product;
import shoplap.entity.Review;

@Controller
@RequestMapping("/shop")
public class ReviewController {
	ReviewDaoImpl reviewDaoImpl = new ReviewDaoImpl();
	RedirectView redirectView = new RedirectView();
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@RequestMapping(value = "add-review", method = RequestMethod.POST)
	public RedirectView review1(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String title = request.getParameter("title");
		String star = request.getParameter("star");
		String content = request.getParameter("content");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(date);

		Review review = new Review(1, Integer.valueOf(id), username, title, star, content, today);
		reviewDaoImpl.insert(review);
		Product product = productDaoImpl.get(Integer.valueOf(id));
		if (product.getRate() == 0.0) {
			product.setRate(Float.valueOf(star));
		} else {
			List<Review> reviews = reviewDaoImpl.getReviewByIdProduct(product.getId());
			float newRate = (product.getRate() * reviews.size() + Float.valueOf(star)) / (reviews.size() + 1);
			newRate = (float) Math.round(newRate * 10) / 10;
			product.setRate(newRate);
		}
		productDaoImpl.edit(product);
		redirectView.setUrl("http://localhost:8080/SHOPLAP/shop/product-detail.htm?id=" + id);
		return redirectView;
	}

}
