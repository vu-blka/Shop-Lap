package shoplap.dao;

import java.util.List;

import shoplap.entity.Product;


public interface ProductDao {
	void insert(Product product);
	boolean edit (Product product);
	boolean delete(int id);
	Product get(int id);
	Product get(String name);
	List<Product> getAll();
	List<Product> getProductByCategory(String id_category);
	List<Product> getProductByBrand(int id_brand);
	List<Product> getProductRecommendByBrand(int id_brand, int id);
	List<Product> searchProductByKeywordName(String keyword);
	List<Product> getProductOnSale();
	List<Product> getProductTrending();
	List<Product> getTopProduct();
	List<Product> getTopTrendingProduct();
	List<Product> getByCB(String idc, int idb);
}
