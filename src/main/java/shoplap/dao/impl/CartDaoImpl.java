package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.CartDao;
import shoplap.entity.Cart;
import shoplap.entity.Category;
import shoplap.entity.Product;
import shoplap.jdbc.connectDB;

public class CartDaoImpl implements CartDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO cart_items(id, username, quantity) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(cart.getProduct().getId()));
			ps.setString(2, cart.getUsername());
			ps.setString(3, String.valueOf(cart.getQuantity()));
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert cart failed!");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "UPDATE cart_items SET quantity = ? WHERE id=? and username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(cart.getQuantity()));
			System.out.println("quantity dao:" + cart.getQuantity());
			ps.setString(2, String.valueOf(cart.getProduct().getId()));

			ps.setString(3, cart.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update cart failed!");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM cart_items WHERE id = ? and username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(cart.getProduct().getId()));
			ps.setString(2, cart.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete cart failed!");
			e.printStackTrace();
		}
	}

	@Override
	public Cart get(int idProduct, String username) {
		// TODO Auto-generated method stub
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		Product product = productDaoImpl.get(idProduct);
		String sql = "SELECT * FROM cart_items WHERE id=? and username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(idProduct));
			ps.setString(2, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setProduct(product);
				cart.setUsername(username);
				cart.setQuantity(Integer.valueOf(rs.getString("quantity")));
				return cart;
			}
		} catch (SQLException e) {
			System.out.println("get cart failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cart> getCartsByUsername(String username) {
		// TODO Auto-generated method stub
		List<Cart> list = new ArrayList<Cart>();
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		 
		String sql = "SELECT * FROM cart_items WHERE username=?";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setProduct(productDaoImpl.get(rs.getString("id")));
				cart.setUsername(username);
				cart.setQuantity(Integer.valueOf(rs.getString("quantity")));
				list.add(cart);
			}
		} catch (SQLException e) {
			System.out.println("get list cart failed!");
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
