package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.BrandDao;
import shoplap.entity.Brand;
import shoplap.jdbc.connectDB;

public class BrandDaoImpl implements BrandDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();

	@Override
	public boolean insert(Brand brand) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO brands(brand,img) VALUES ( ?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, brand.getBrand().trim());
			ps.setString(2, brand.getImg().trim());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert brand failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(Brand brand) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Brands SET brand = ?, img=? WHERE id_brand = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, brand.getBrand().trim());
			ps.setString(2, brand.getImg().trim());
			ps.setString(3, String.valueOf(brand.getId()).trim());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("edit brand failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM brands WHERE id_brand = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error delete brand ");
		}
		return false;
	}

	@Override
	public Brand get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM brands WHERE id_brand = ? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Brand brand = new Brand();

				brand.setId(Integer.valueOf(rs.getString("id_brand").trim()));
				brand.setBrand(rs.getString("brand").trim());
				brand.setImg(rs.getString("img").trim());
				return brand;
			}
		} catch (SQLException e) {
			System.out.println("update brand failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		List<Brand> brands = new ArrayList<Brand>();
		String sql = "SELECT * FROM brands";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand Brand = new Brand();

				Brand.setId(Integer.valueOf(rs.getString("id_Brand").trim()));
				Brand.setBrand(rs.getString("Brand").trim());
				Brand.setImg(rs.getString("img").trim());

				brands.add(Brand);
			}
		} catch (SQLException e) {
			System.out.println("error get all brand ");
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public List<Brand> getPopularBrand() {
		// TODO Auto-generated method stub
		List<Brand> brands = new ArrayList<Brand>();
		String sql = "select top 4 PRODUCTS.id_brand, BRANDS.brand,brands.img , sum(quantity_sold) AS tong from PRODUCTS,BRANDS WHERE PRODUCTS.id_brand=BRANDS.id_brand group by PRODUCTS.id_brand, BRANDS.brand, brands.img ORDER BY tong DESC";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();

				brand.setId(Integer.valueOf(rs.getString("id_Brand").trim()));
				brand.setBrand(rs.getString("Brand").trim());
				brand.setImg(rs.getString("img").trim());
				brands.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get popular brand ");
		}
		return brands;
	}

	@Override
	public Brand getBrandByIdProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "select brands.id_brand , brand, brands.img from brands,products where brands.id_brand = products.id_brand and products.id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(Integer.valueOf(rs.getString("id_brand").trim()));
				brand.setBrand(rs.getString("brand").trim());
				brand.setImg(rs.getString("img").trim());
				return brand;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get brand by product");
		}
		return null;
	}

}
