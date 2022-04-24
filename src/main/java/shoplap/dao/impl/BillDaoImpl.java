package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shoplap.dao.BillDao;
import shoplap.entity.Bill;
import shoplap.jdbc.connectDB;

public class BillDaoImpl implements BillDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	PaymentDaoImpl paymentDaoImpl = new PaymentDaoImpl();
	ShippingDaoImpl shippingDaoImpl = new ShippingDaoImpl();

	@Override
	public void insert(Bill bill) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO bills( id_bill,username, fullname, "
				+ "phone,mail, address, note, id_payment, money, date, id_shipping) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(bill.getIdBill()));
			ps.setString(2, bill.getUsername());
			ps.setString(3, bill.getFullname());
			ps.setString(4, bill.getPhone());
			ps.setString(5, bill.getMail());
			ps.setString(6, bill.getAddress());
			ps.setString(7, bill.getNote());
			ps.setString(8, String.valueOf(bill.getPayment().getIdPayment()));
			ps.setString(9, bill.getMoney());
			ps.setString(10, bill.getDate());
			ps.setString(11, String.valueOf(bill.getShipping().getIdShipping()));

			ps.executeUpdate();
			System.out.println(" insert bill");
		} catch (SQLException e) {
			System.out.println("error insert bills");
		}
	}

	@Override
	public Bill get(int idBill) {
		String sql = "SELECT * FROM bills WHERE id_bill = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idBill);
			rs = ps.executeQuery();
			Bill bill = new Bill();
			while (rs.next()) {
				bill.setIdBill(idBill);
				bill.setUsername(rs.getString("username"));
				bill.setFullname(rs.getString("fullname"));
				bill.setPhone(rs.getString("phone"));
				bill.setMail(rs.getString("mail"));
				bill.setAddress(rs.getString("address"));
				bill.setNote(rs.getString("note"));
				bill.setPayment(paymentDaoImpl.get(Integer.valueOf(rs.getString("id_payment"))));
				bill.setMoney(rs.getString("money"));
				bill.setDate(rs.getString("date"));
				bill.setShipping(shippingDaoImpl.get(Integer.valueOf(rs.getString("id_shipping"))));

			}

			return bill;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get bill");
		}
		return null;
	}

	@Override
	public int count() {
		String sql = "SELECT count(id_bill) as count FROM bills ";
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = Integer.valueOf(rs.getString("count"));
			}
			return count;
		} catch (SQLException e) {
			System.out.println("error count bill");
		}
		return count;
	}

	@Override
	public void update(Bill bill) {
		String sql = "INSERT INTO bills( money) VALUES (?) where id_bill=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bill.getMoney());
			ps.setString(2, String.valueOf(bill.getIdBill()));
			ps.executeUpdate();
			System.out.println(" update bills");
		} catch (SQLException e) {
			System.out.println("error update bills");
		}
	}
}
