package shoplap.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import shoplap.dao.impl.BrandDaoImpl;
import shoplap.dao.impl.CategoryDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Category;
import shoplap.entity.Product;

@Controller
@Transactional
@RequestMapping("/")
public class HomeController {
	CategoryDaoImpl categoryDaoImpl=new CategoryDaoImpl();
	BrandDaoImpl brandDaoImpl=new BrandDaoImpl();
	ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	@RequestMapping("index")
	public String index(ModelMap model) {
		List<Category> categories = categoryDaoImpl.getAll();
		List<Brand> brands = brandDaoImpl.getAll();
		List<Product> productsOnSale = productDaoImpl.getProductOnSale();
		List<Product> productsTrending = productDaoImpl.getProductTrending();
		List<Product> topProducts = productDaoImpl.getTopProduct();
		List<Brand> popularBrands=brandDaoImpl.getPopularBrand();
		List<Product> topTrendingProducts = productDaoImpl.getTopTrendingProduct();
		model.addAttribute("categories", categories);
		model.addAttribute("brands", brands);
		model.addAttribute("productsOnSale", productsOnSale);
		model.addAttribute("topProducts", topProducts);
		model.addAttribute("popularBrands", popularBrands);
		model.addAttribute("topTrendingProducts", topTrendingProducts);
		model.addAttribute("productsTrending", productsTrending);
		model.addAttribute("title", "Maxon");
		return "index";
	}

	@RequestMapping("error")
	public String error404(ModelMap model) {
		return "error";
	}
}
