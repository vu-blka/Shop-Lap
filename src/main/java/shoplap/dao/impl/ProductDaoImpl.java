package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.ProductDao;
import shoplap.entity.Product;
import shoplap.jdbc.connectDB;

public class ProductDaoImpl implements ProductDao {
	CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
	BrandDaoImpl brandDaoImpl = new BrandDaoImpl();
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO products( name, price,rate,sale, description, quantity, quantity_sold, link_img, id_category, id_brand) VALUES (?, ?,0, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, String.valueOf(product.getPrice()));

			ps.setString(3, String.valueOf(product.getSale()));
			ps.setString(4, product.getDescription());
			ps.setString(5, String.valueOf(product.getQuantity()));
			ps.setString(6, String.valueOf(product.getQuantitySold()));
			ps.setString(7, product.getImg());

			ps.setString(8, product.getCategory().getId());

			ps.setString(9, String.valueOf(product.getBrand().getId()));
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error insert product");
		}
	}

	@Override
	public boolean edit(Product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE products SET name = ?, price = ?, rate = ?, sale = ?, description = ?, quantity = ?, quantity_sold = ?, link_img = ?, id_category=?, id_brand=? WHERE id = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getName());
			ps.setString(2, String.valueOf(product.getPrice()));
			ps.setString(3, String.valueOf(product.getRate()));
			ps.setString(4, String.valueOf(product.getSale()));
			ps.setString(5, product.getDescription());
			ps.setString(6, String.valueOf(product.getQuantity()));
			ps.setString(7, String.valueOf(product.getQuantitySold()));
			ps.setString(8, product.getImg());
			ps.setString(9, product.getCategory().getId());
			ps.setString(10, String.valueOf(product.getBrand().getId()));
			ps.setString(11, String.valueOf(product.getId()));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error edit product");
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM products WHERE id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.getBrandByIdProduct(product.getId()));
				return product;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get product");
		}
		return null;
	}

	@Override
	public Product get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.getBrandByIdProduct(product.getId()));

				products.add(product);
			}

		} catch (SQLException e) {
			System.out.println("error get all product");
		}
		return products;
	}

	@Override
	public List<Product> getProductByCategory(String id_category) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE id_category=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id_category);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(product.getId()));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getProductByBrand(int id_brand) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE id_brand= ? order by quantity_sold desc";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id_brand));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.getBrandByIdProduct(product.getId()));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error product by brand");
		}
		return products;
	}

	@Override
	public List<Product> searchProductByKeywordName(String keyword) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE name LIKE ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(product.getId()));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getProductOnSale() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE sale > 3 and quantity!=0";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(Integer.valueOf(rs.getString("id_brand"))));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getTopProduct() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		String sql = "select top 4 * from PRODUCTS where quantity!=0 order by quantity_sold desc ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(Integer.valueOf(rs.getString("id_brand"))));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getProductTrending() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<Product>();
		String sql = "select top 8 * from PRODUCTS where quantity!=0 order by id desc ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(Integer.valueOf(rs.getString("id_brand"))));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public List<Product> getTopTrendingProduct() {
		// TODO Auto-generated method stub
		int trend = 0;
		String sql0 = "select max(id) AS maxId from PRODUCTS where quantity!=0";
		try {
			PreparedStatement ps = conn.prepareStatement(sql0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trend = Integer.valueOf(rs.getString("maxId")) - 15;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("get max id error");
		}
		System.out.println(trend);

		List<Product> productList = new ArrayList<Product>();
		String sql = "select top 4 * from PRODUCTS where id> ? order by quantity_sold desc ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(trend));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.get(Integer.valueOf(rs.getString("id_brand"))));
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> getProductRecommendByBrand(int id_brand, int id) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT top 8 * FROM products WHERE quantity!=0 and id_brand= ? and id not in (?) order by quantity_sold desc ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id_brand));
			ps.setString(2, String.valueOf(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.getBrandByIdProduct(product.getId()));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error product by brand");
		}
		return products;
	}

	public List<Product> getByCB(String idc, int idb) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM products WHERE id_brand= ? and id_category=? order by quantity_sold desc";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(idb));
			ps.setString(2, idc);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(Integer.valueOf(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setPrice(Integer.valueOf(rs.getString("price")));
				product.setRate(Float.valueOf(rs.getString("rate")));
				product.setSale(Integer.valueOf(rs.getString("sale")));
				product.setDescription(rs.getString("description"));
				product.setQuantity(Integer.valueOf(rs.getString("quantity")));
				product.setQuantitySold(Integer.valueOf(rs.getString("quantity_sold")));
				product.setImg(rs.getString("link_img"));
				product.setCategory(categoryDaoImpl.getCategoryByIdProduct(product.getId()));
				product.setBrand(brandDaoImpl.getBrandByIdProduct(product.getId()));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error product by brand");
		}
		return products;

	}
}
