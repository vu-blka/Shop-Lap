package shoplap.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.entity.Admin;
import shoplap.entity.User;
import shoplap.jdbc.connectDB;
import shoplap.service.AdminService;

public class AdminServiceImpl implements AdminService {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public Admin checkLoginAdmin(String username, String password) {
		try {
			String query = "select id_admin, PASSWORD,fullname from ADMINS where ID_ADMIN = ? AND PASSWORD = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username.trim());
			ps.setString(2, password.trim());
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setUsername(rs.getString("id_admin"));
				admin.setPassword(rs.getString("password"));
				admin.setFullname(rs.getString("fullname"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admins ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Admin admin = new Admin();

				admin.setFullname(rs.getString("fullname"));
				admin.setPassword(rs.getString("password"));

				admin.setUsername(rs.getString("id_admin"));
				list.add(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get all admins");
		}
		return null;
	}

	@Override
	public boolean insert(Admin admin) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO admins(id_admin, password, fullname) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getFullname());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert account admin failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(Admin admin) {
		// TODO Auto-generated method stub
		String sql = "update admins set password = ? where id_admin =?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, admin.getPassword());
			ps.setString(2, String.valueOf(admin.getUsername()));
			ps.executeUpdate();
			System.out.println(" updated admin");
			return true;
		} catch (SQLException e) {
			System.out.println("error update admin");
		}
		return false;
	}

	@Override
	public Admin get(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM admins WHERE id_admin = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setUsername(rs.getString("id_admin"));
				admin.setPassword(rs.getString("password"));
				admin.setFullname(rs.getString("fullname"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get user by username");
		}
		return null;
	}

}
