package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.UserDao;
import shoplap.entity.Product;
import shoplap.entity.User;
import shoplap.jdbc.connectDB;

public class UserDaoImpl implements UserDao {

	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean insert(User user) {
		String sql = "INSERT INTO users(username, password, fullname, phone, mail) VALUES (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert account failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO accounts(username, password, fullname, phone, mail) VALUES (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("edit account failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("mail"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get user by username");
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		String sql = "select * from users ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("mail"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error get all user");
		}	
		return null;
	}

}
