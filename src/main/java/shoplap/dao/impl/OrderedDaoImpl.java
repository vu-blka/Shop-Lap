package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.OrderedDao;
import shoplap.entity.Ordered;
import shoplap.jdbc.connectDB;

public class OrderedDaoImpl implements OrderedDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	OrderedItemDaoImpl orderedItemDaoImpl = new OrderedItemDaoImpl();

	@Override
	public void insert(Ordered ordered) {
		String sql = "INSERT INTO ordered(id_ordered,id_bill) VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(ordered.getIdOrdered()));
			ps.setString(2, String.valueOf(ordered.getIdBill()));
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert ordered failed!");
			e.printStackTrace();
		}
	}

	@Override
	public int count() {
		String sql = "SELECT count(id_ordered) as count FROM ordered ";
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = Integer.valueOf(rs.getString("count"));
			}
			return count;
		} catch (SQLException e) {
			System.out.println("error count ordered");
		}
		return count;

	}

	@Override
	public List<Ordered> getNull() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ordered where id_admin is null";
		List<Ordered> list = new ArrayList<Ordered>();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Ordered ordered = new Ordered();
				ordered.setIdOrdered(Integer.valueOf(rs.getString("id_ordered")));
				ordered.setIdAdmin("");
				ordered.setIdBill(Integer.valueOf(rs.getString("id_bill")));
				list.add(ordered);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error get all ordered");
		}
		return null;
	}

	@Override
	public List<Ordered> getNotNull() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ordered where id_admin is not null";
		List<Ordered> list = new ArrayList<Ordered>();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Ordered ordered = new Ordered();
				ordered.setIdOrdered(Integer.valueOf(rs.getString("id_ordered")));
				ordered.setIdAdmin(rs.getString("id_admin").trim());
				ordered.setIdBill(Integer.valueOf(rs.getString("id_bill")));
				list.add(ordered);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error get all ordered");
		}
		return null;
	}

	@Override
	public Ordered get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ordered where id_ordered=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Ordered ordered = new Ordered();
				ordered.setIdOrdered(Integer.valueOf(rs.getString("id_ordered")));
				ordered.setIdAdmin(rs.getString("id_admin"));
				ordered.setIdBill(Integer.valueOf(rs.getString("id_bill")));
				return ordered;
			}

		} catch (SQLException e) {
			System.out.println("error get all ordered");
		}
		return null;
	}

	@Override
	public boolean update(Ordered ordered) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ordered SET id_admin = ? WHERE id_ordered=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(ordered.getIdAdmin()));

			ps.setString(2, String.valueOf(ordered.getIdOrdered()));

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("update ordered failed!");
			e.printStackTrace();
		}
		return false;
	}
}
