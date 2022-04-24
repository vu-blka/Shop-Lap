package shoplap.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shoplap.dao.impl.BrandDaoImpl;
import shoplap.dao.impl.CategoryDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Category;
import shoplap.entity.Product;

@Controller
@RequestMapping("/admin/")
public class AdminProductController {
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
	BrandDaoImpl brandDaoImpl = new BrandDaoImpl();

	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String viewProductList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			List<Product> list = productDaoImpl.getAll();
			int totalPage = list.size() % 6 == 0 ? (list.size() / 6) : (int) (list.size() / 6 + 1);
			int page = Integer.valueOf(request.getParameter("page"));
			List<Product> listShow = new ArrayList<Product>();
			int start = (page - 1) * 6;

			for (int i = start; i < start + 6; i++) {
				if (i == list.size()) {
					break;
				}
				listShow.add(list.get(i));

			}
			String message = request.getParameter("message");

			model.addAttribute("message", message);
			model.addAttribute("listProduct", listShow);
			model.addAttribute("page", page);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("totalItem", list.size());
			model.addAttribute("countItem", 6);
			return "admin/product_list";
		}
		return "error";
	}

//	@RequestMapping(value = "product/{page}", method = RequestMethod.GET)
//	public String viewProductListByPage(ModelMap model, @PathVariable("page") int page) {
//		model.addAttribute("listProduct", productService.getListNav((page - 1) * 10, 10));
//		model.addAttribute("page", productService.countTotalRecords() / 10);
//		model.addAttribute("totalItem", productService.countTotalRecords());
//		if ((page * 10) > productService.countTotalRecords()) {
//			model.addAttribute("countItem", productService.countTotalRecords() - (page - 1) * 10);
//		} else {
//			model.addAttribute("countItem", 10);
//		}
//		return "admin/product_list";
//	}
//
	@RequestMapping(value = "product/insert", method = RequestMethod.GET)
	public String product_form(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			model.addAttribute("product", new Product());
			List<Category> categories = categoryDaoImpl.getAll();
			model.addAttribute("categories", categories);
			List<Brand> brands = brandDaoImpl.getAll();
			model.addAttribute("brands", brands);
			return "admin/product_form";
		} else {
			return "error";
		}
	}

//
	@RequestMapping(value = "product/insert", method = RequestMethod.POST)
	public String product_form(ModelMap model, HttpServletRequest request) {
//		ServletContext context = request.getSession().getServletContext();
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {

			String photo = request.getParameter("photo");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String sale = request.getParameter("sale");
			String quantity = request.getParameter("quantity");
			String id_category = request.getParameter("category");
			Category category = categoryDaoImpl.get(id_category);
			String id_brand = request.getParameter("brand");
			Brand brand = brandDaoImpl.get(Integer.valueOf(id_brand));
			String description = request.getParameter("description");

			if (name.isEmpty() || photo.isEmpty() || price.isEmpty() || sale.isEmpty() || description.isEmpty()
					|| quantity.isEmpty() || id_brand.isEmpty() || id_category.isEmpty()) {
				model.addAttribute("message", "Nhập thiếu thông tin!");
			} else {
				Product product = new Product();
				product.setName(name);
				product.setPrice(Integer.valueOf(price));
				product.setSale(Integer.valueOf(sale));
				product.setQuantity(Integer.valueOf(quantity));
				product.setCategory(category);
				product.setBrand(brand);
				product.setDescription(description);
				product.setImg(photo);
				product.setQuantitySold(0);

				productDaoImpl.insert(product);
				model.addAttribute("message", "Thêm sản phẩm mới thành công!");
			}

			//

			//
			model.addAttribute("product", new Product());
			List<Category> categories = categoryDaoImpl.getAll();
			model.addAttribute("categories", categories);
			List<Brand> brands = brandDaoImpl.getAll();
			model.addAttribute("brands", brands);

			return "admin/product_form";
		} else {
			return "error";
		}
	}

//
	@RequestMapping(value = "product/update", method = RequestMethod.GET)
	public String editProduct(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Product product = productDaoImpl.get(Integer.valueOf(id));
			model.addAttribute("product", product);

			List<Category> categories = categoryDaoImpl.getAll();
			model.addAttribute("categories", categories);
			List<Brand> brands = brandDaoImpl.getAll();
			model.addAttribute("brands", brands);
			return "admin/product_update";
		} else {
			return "error";
		}
	}

//
	@RequestMapping(value = "product/update", method = RequestMethod.POST)
	public String editProduct1(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			String id = request.getParameter("id");
			Product product = productDaoImpl.get(Integer.valueOf(id));

			//
			String photo = request.getParameter("photo");

			if (photo.equals("")) {
				photo += product.getImg().trim();
			}

			String name = request.getParameter("name");

			String price = request.getParameter("price");

			String sale = request.getParameter("sale");

			String quantity = request.getParameter("quantity");

			String id_category = request.getParameter("category");

			Category category = categoryDaoImpl.get(id_category);
			String id_brand = request.getParameter("brand");

			Brand brand = brandDaoImpl.get(Integer.valueOf(id_brand));
			String description = request.getParameter("description");

			String rate = request.getParameter("rate");

			String quantitySold = request.getParameter("quantitySold");

			//
			Product newProduct = new Product(Integer.valueOf(id), name, Integer.valueOf(price), Float.valueOf(rate),
					Integer.valueOf(sale), description, Integer.valueOf(quantity), Integer.valueOf(quantitySold), photo,
					category, brand);
			boolean check = productDaoImpl.edit(newProduct);
			if (check) {
				model.addAttribute("message", "Chỉnh sửa sản phẩm thành công!");
			} else {
				model.addAttribute("message", "Chỉnh sửa sản phẩm không thành công!");
			}

			//

			//
			model.addAttribute("product", newProduct);
			List<Category> categories = categoryDaoImpl.getAll();
			model.addAttribute("categories", categories);
			List<Brand> brands = brandDaoImpl.getAll();
			model.addAttribute("brands", brands);

			return "admin/product_update";
		} else {
			return "error";
		}
	}

//
	@RequestMapping("product/remove.htm")
	public String deleteProduct(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean check = productDaoImpl.delete(Integer.valueOf(id));
		if (check) {
			model.addAttribute("message", "Xóa thành công!");
		} else {
			model.addAttribute("message", "Xóa thất bại!");
		}
		return "redirect:/admin/product.htm?page=1";
	}
}
