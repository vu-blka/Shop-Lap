package shoplap.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import shoplap.dao.impl.BrandDaoImpl;
import shoplap.dao.impl.CategoryDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.dao.impl.ReviewDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Category;
import shoplap.entity.Product;
import shoplap.entity.Review;

@Controller
@RequestMapping("/shop")
public class ShopController {
	CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
	BrandDaoImpl brandDaoImpl = new BrandDaoImpl();
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	List<Category> categories = categoryDaoImpl.getAll();
	List<Product> products = new ArrayList<Product>();
	List<Brand> brands = brandDaoImpl.getAll();
	RedirectView redirectView = new RedirectView();
	ReviewDaoImpl reviewDaoImpl = new ReviewDaoImpl();

	@RequestMapping()
	public String shop(ModelMap model, HttpServletRequest request) {
		products = productDaoImpl.getAll();
		int totalPage = products.size() % 6 == 0 ? (products.size() / 6) : (int) (products.size() / 6 + 1);
		int page = Integer.valueOf(request.getParameter("page"));
		List<Product> listShow = new ArrayList<Product>();
		int start = (page - 1) * 6;

		for (int i = start; i < start + 6; i++) {
			if (i == products.size()) {
				break;
			}
			listShow.add(products.get(i));

		}
		Collections.shuffle(listShow);
		model.addAttribute("listShow", listShow);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("categories", categories);
		model.addAttribute("brandList", brands);
		model.addAttribute("title", "Shop");
		model.addAttribute("search", "");
		model.addAttribute("keyword", "");
		model.addAttribute("listSize", listShow.size());
		return "shop";
	}

	@RequestMapping("product-detail")
	public String productDetail(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productDaoImpl.get(Integer.valueOf(id));
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		List<Product> productBrand = productDaoImpl.getProductRecommendByBrand(product.getBrand().getId(),
				product.getId());
		Collections.shuffle(productBrand);
		List<Review> reviews = new ArrayList<Review>();
		reviews = reviewDaoImpl.getReviewByIdProduct(Integer.valueOf(id));
		model.addAttribute("productBrand", productBrand);
		model.addAttribute("reviews", reviews);
		int count5 = 0;
		int count4 = 0;
		int count3 = 0;
		int count2 = 0;
		int count1 = 0;

		int size = reviews.size();
		for (int i = 0; i < size; i++) {
			if (reviews.get(i).getStar().trim().equals("5")) {
				count5++;
			} else if (reviews.get(i).getStar().trim().equals("4")) {
				count4++;
			} else if (reviews.get(i).getStar().trim().equals("3")) {
				count3++;
			} else if (reviews.get(i).getStar().trim().equals("2")) {
				count2++;
			} else if (reviews.get(i).getStar().trim().equals("1")) {
				count1++;
			}
		}
		model.addAttribute("per5", (int) (((float) count5 / size) * 100));
		model.addAttribute("per4", (int) (((float) count4 / size) * 100));
		model.addAttribute("per3", (int) (((float) count3 / size) * 100));
		model.addAttribute("per2", (int) (((float) count2 / size) * 100));
		model.addAttribute("per1", (int) (((float) count1 / size) * 100));

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username == null) {
			model.addAttribute("showReviewForm", false);
			System.out.println("Chưa đăng nhập");
		} else {
			boolean isReviewed = true;
			System.out.println("size " + reviews.size());
			for (int i = 0; i < reviews.size(); i++) {
				if (reviews.get(i).getUsername().trim().equals(username)) {
					isReviewed = false;

					break;

				}
			}

			model.addAttribute("showReviewForm", isReviewed);
		}
		return "product-detail";
	}

	@RequestMapping("filter")
	public String filter(ModelMap model, HttpServletRequest request) {

		boolean sideBar = false;
		if (!request.getParameter("IdCategory").equals("") && !request.getParameter("IdBrand").equals("")) {
			String IdBrand = request.getParameter("IdBrand");
			String idCategory = request.getParameter("IdCategory");
			Brand brand = brandDaoImpl.get(Integer.valueOf(IdBrand));
			Category category = categoryDaoImpl.get(idCategory);
			products = productDaoImpl.getByCB(idCategory, Integer.valueOf(IdBrand));
			model.addAttribute("title", "Shop Brand: " + brand.getBrand() + " & Category: " + category.getCategory());
			model.addAttribute("showb", 0);
			model.addAttribute("categories", categories);
			model.addAttribute("brandList", brands);
			model.addAttribute("search", "IdBrand=" + IdBrand);

			System.out.println("FILTER BY BRAND & CATEGORY");
			
		} else if (!request.getParameter("IdCategory").equals("")) {
			System.out.println("FILTER BY CATEGORY");
			String idCategory = request.getParameter("IdCategory");

			Category category = categoryDaoImpl.get(idCategory);

			products = productDaoImpl.getProductByCategory(idCategory);

			model.addAttribute("title", "Shop Category: " + category.getCategory());
			model.addAttribute("search", "IdCategory" + idCategory);
			model.addAttribute("brandList", brands);
			model.addAttribute("idcategory", category.getId());
			model.addAttribute("idBrand", request.getParameter("idBrand"));
			sideBar = true;
		} else if (!request.getParameter("IdBrand").equals("")) {
			System.out.println("FILTER BY BRAND");
			String IdBrand = request.getParameter("IdBrand");
			Brand brand = brandDaoImpl.get(Integer.valueOf(IdBrand));
			products = productDaoImpl.getProductByBrand(Integer.valueOf(IdBrand));
			model.addAttribute("title", "Shop Brand: " + brand.getBrand());
			model.addAttribute("search", "IdBrand=" + IdBrand);
			model.addAttribute("categories", categories);
			model.addAttribute("idbrand", brand.getId());
			String idCategory = request.getParameter("idCategory");
			model.addAttribute("idCategory", idCategory);
			sideBar = true;
		}
		model.addAttribute("sideBar", sideBar);
		model.addAttribute("shown", 0);
		int totalPage = products.size() % 6 == 0 ? (products.size() / 6) : (int) (products.size() / 6 + 1);
		int page = Integer.valueOf(request.getParameter("page"));
		List<Product> listShow = new ArrayList<Product>();
		int start = (page - 1) * 6;
		for (int i = start; i < start + 6; i++) {
			if (i == products.size()) {
				break;
			}
			listShow.add(products.get(i));

		}
		Collections.shuffle(listShow);
		model.addAttribute("listShow", listShow);
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("listSize", listShow.size());
		return "shop";
	}

	@RequestMapping("search")
	public String search(ModelMap model, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		products = productDaoImpl.searchProductByKeywordName(keyword);
//			model.addAttribute("title", "Shop Category: " + categoryDaoImpl.get(idCategory).getCategory());
//			model.addAttribute("search", "IdCategory" + idCategory);

		int totalPage = products.size() % 6 == 0 ? (products.size() / 6) : (int) (products.size() / 6 + 1);
		int page = Integer.valueOf(request.getParameter("page"));
		List<Product> listShow = new ArrayList<Product>();

		int start = (page - 1) * 6;
		for (int i = start; i < start + 6; i++) {
			if (i == products.size()) {
				break;
			}
			listShow.add(products.get(i));
		}
		System.out.println("listshow" + listShow.size());

		model.addAttribute("categories", categories);
		model.addAttribute("brandList", brands);
		model.addAttribute("keyword", keyword);

		Collections.shuffle(listShow);
		model.addAttribute("listShow", listShow);
		model.addAttribute("listSize", listShow.size());
		model.addAttribute("page", page);
		model.addAttribute("totalPage", totalPage);
		return "shop";
	}
}
