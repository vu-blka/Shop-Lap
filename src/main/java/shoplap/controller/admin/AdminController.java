package shoplap.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import shoplap.dao.impl.OrderedDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.dao.impl.UserDaoImpl;
import shoplap.entity.Brand;
import shoplap.entity.Ordered;
import shoplap.service.impl.BrandServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminController {

	UserDaoImpl userDaoImpl = new UserDaoImpl();
//	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	BrandServiceImpl brandServiceImpl = new BrandServiceImpl();

	@RequestMapping("index")
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminsession") != null) {
			model.addAttribute("sizeUser", userDaoImpl.getAll().size());
//			model.addAttribute("listProduct", productDaoImpl.getAll());
			List<Brand> listBrands = brandServiceImpl.getAll();
			for (int i = 0; i < listBrands.size(); i++) {
				int id = listBrands.get(i).getId();
				System.out.println("id "+id);
				System.out.println("sold "+ brandServiceImpl.getQuantitySoldByBrand(id));
				listBrands.get(i).setCountProduct(brandServiceImpl.getCountProductByBrand(id));
				listBrands.get(i).setSold(Integer.valueOf(brandServiceImpl.getQuantitySoldByBrand(id)));
			}
			model.addAttribute("listBrands", listBrands);
			return "admin/index";
		}
		return "error";
	}
}
