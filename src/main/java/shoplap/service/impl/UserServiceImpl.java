package shoplap.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.impl.CartDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.entity.Cart;
import shoplap.entity.Product;
import shoplap.entity.User;
import shoplap.jdbc.connectDB;
import shoplap.service.UserService;

public class UserServiceImpl implements UserService {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			String query = "select USERNAME, PASSWORD from userS where USERNAME = ? AND PASSWORD = ? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO users(username, password, fullname, phone, mail) VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
	public boolean edit(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET PASSWORD=?,FULLNAME = ?, PHONE= ?, MAIL= ? WHERE USERNAME = ?";
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getUsername());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("error update user");
		}
		return false;
	}

	@Override
	public List<Cart> getCartsByUsername(String username) {
		// TODO Auto-generated method stub
		List<Cart> list = new ArrayList<Cart>();
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		String sql = "SELECT * FROM cart_items WHERE username=? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setProduct(productDaoImpl.get(Integer.valueOf(rs.getString("id"))));
				cart.setUsername(rs.getString("username"));
				cart.setQuantity(Integer.valueOf(rs.getString("quantity")));
				list.add(cart);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error get carts by username");
		}
		return list;
	}
}