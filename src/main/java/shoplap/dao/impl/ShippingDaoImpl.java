package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.ShippingDao;
import shoplap.entity.Cart;
import shoplap.entity.Payment;
import shoplap.entity.Product;
import shoplap.entity.Shipping;
import shoplap.jdbc.connectDB;

public class ShippingDaoImpl implements ShippingDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<Shipping> getAll() {
		// TODO Auto-generated method stub
		List<Shipping> list = new ArrayList<Shipping>();
		String sql = "select * from Shippings";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Shipping shipping = new Shipping();
				shipping.setIdShipping(Integer.valueOf(rs.getString("id_shipping")));
				shipping.setMethod(rs.getString("method"));
				shipping.setFee(Integer.valueOf(rs.getString("fee")));
				list.add(shipping);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error get all shipping");
		}
		return null;
	}

	@Override
	public Shipping get(int idShipping) {
		// TODO Auto-generated method stub
		String sql = "select * from Shippings where id_shipping=?";
		Shipping shipping = new Shipping();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(idShipping));
			rs = ps.executeQuery();
			while (rs.next()) {
				shipping.setIdShipping(idShipping);
				shipping.setMethod(rs.getString("method"));
				shipping.setFee(Integer.valueOf(rs.getString("fee")));
			}
			return shipping;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error get shipping");
		}
		return null;
	}

	@Override
	public boolean insert(Shipping shipping) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO shippings(method,fee) VALUES (?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, shipping.getMethod());
			ps.setString(2, String.valueOf(shipping.getFee()));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert shipping failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Shipping shipping) {
		// TODO Auto-generated method stub

		String sql = "UPDATE shippings SET method = ?,fee=? WHERE id_shipping = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, shipping.getMethod());
			ps.setString(2, String.valueOf(shipping.getFee()));
			ps.setString(3, String.valueOf(shipping.getIdShipping()));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("update payment failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM shippings WHERE id_shipping = ?";
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

}
