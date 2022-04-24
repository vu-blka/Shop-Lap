package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shoplap.dao.ContactDao;
import shoplap.entity.Contact;
import shoplap.entity.Payment;
import shoplap.jdbc.connectDB;

public class ContactDaoImpl implements ContactDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public Contact get(int branch) {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		String sql = "select * from contacts where branch=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(branch));
			rs = ps.executeQuery();
			while (rs.next()) {
				contact.setBranch(branch);
				contact.setLocation(rs.getString("location"));
				contact.setMail1(rs.getString("mail1"));
				contact.setMail2(rs.getString("mail2"));
				contact.setPhone1(rs.getString("phone1"));
				contact.setPhone2(rs.getString("phone2"));
				contact.setMap(rs.getString("map"));
			}
			return contact;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error get contact");
		}
		return null;
	}

}
