package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.CategoryDao;
import shoplap.entity.Category;
import shoplap.jdbc.connectDB;

public class CategoryDaoImpl implements CategoryDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public boolean insert(Category category) {
		String sql = "INSERT INTO Categories(id_category,category) VALUES (?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getId().trim());
			ps.setString(2, category.getCategory().trim());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert category failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(Category category) {
		String sql = "UPDATE Categories SET category = ? WHERE id_category = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategory().trim());
			ps.setString(2, category.getId().trim());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("edit category failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category get(String id) {
		String sql = "SELECT * FROM Categories WHERE id_category = ? ";
		Category category = new Category();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {

				category.setId(rs.getString("id_category").trim());
				category.setCategory(rs.getString("category").trim());

			}
			return category;
		} catch (SQLException e) {
			System.out.println("get category failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM Categories";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getString("id_category").trim());
				category.setCategory(rs.getString("category").trim());

				categories.add(category);
			}
		} catch (SQLException e) {
			System.out.println("get all category failed!");
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean delete(String id) {
		String sql = "DELETE FROM Categories WHERE id_category = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("delete category failed!");
		}
		return false;
	}

	@Override
	public Category getCategoryByIdProduct(int id) {
		String sql = "select categories.id_category ,category from Categories,products where CATEGORIES.id_category = products.id_category and products.id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Category catagory_product = new Category();
				catagory_product.setId(rs.getString("id_category").trim());
				catagory_product.setCategory(rs.getString("category").trim());

				return catagory_product;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get category by product");
		}
		return null;
	}

}
