package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.PaymentDao;
import shoplap.entity.Payment;
import shoplap.jdbc.connectDB;

public class PaymentDaoImpl implements PaymentDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<Payment> getAll() {
		// TODO Auto-generated method stub

		List<Payment> list = new ArrayList<Payment>();
		String sql = "select * from Payments";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Payment payment = new Payment();
				payment.setIdPayment(Integer.valueOf(rs.getString("id_payment")));
				payment.setMethod(rs.getString("method"));
				list.add(payment);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error get all Payment");
		}
		return null;
	}

	@Override
	public Payment get(int idPayment) {
		// TODO Auto-generated method stub
		String sql = "select * from Payments where id_payment=?";
		Payment payment = new Payment();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(idPayment));
			rs = ps.executeQuery();
			while (rs.next()) {
				payment.setIdPayment(Integer.valueOf(rs.getString("id_payment")));
				payment.setMethod(rs.getString("method"));
			}
			return payment;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error get payment");
		}
		return null;
	}

	@Override
	public boolean insert(Payment payment) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO payments(method) VALUES (?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, payment.getMethod());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert payment failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Payment payment) {
		// TODO Auto-generated method stub

		String sql = "UPDATE payments SET method = ? WHERE id_payment = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, payment.getMethod());
			ps.setString(2, String.valueOf(payment.getIdPayment()));
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
		String sql = "DELETE FROM payments WHERE id_payment = ?";
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
