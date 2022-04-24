package shoplap.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import shoplap.dao.impl.BrandDaoImpl;
import shoplap.entity.Brand;
import shoplap.jdbc.connectDB;
import shoplap.service.BrandService;

public class BrandServiceImpl implements BrandService {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	BrandDaoImpl brandDaoImpl = new BrandDaoImpl();

	@Override
	public String getQuantitySoldByBrand(int id) {
		// TODO Auto-generated method stub
		String sql = "select sum(quantity_sold) as sold from BRANDS,PRODUCTS where BRANDS.id_brand=PRODUCTS.id_brand and brands.id_brand=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("sold") != null) {
					return rs.getString("sold");
				} else {
					return "0";
				}

			}

		} catch (SQLException e) {
			System.out.println("get quantity sold by brand failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCountProductByBrand(int id) {
		// TODO Auto-generated method stub
		String sql = "select count(id) as product from BRANDS,PRODUCTS where BRANDS.id_brand=PRODUCTS.id_brand and products.id_brand=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				return Integer.valueOf(rs.getString("product"));

			}

		} catch (SQLException e) {
			System.out.println("get count products by brand failed!");
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandDaoImpl.getAll();
	}

}
