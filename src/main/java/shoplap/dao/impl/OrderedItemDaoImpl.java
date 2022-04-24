package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.OrderedItemDao;
import shoplap.entity.Ordered;
import shoplap.entity.OrderedItem;
import shoplap.jdbc.connectDB;

public class OrderedItemDaoImpl implements OrderedItemDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@Override
	public void insert(int id, int idOrdered, int quantity) {
		String sql = "INSERT INTO OrDERED_ITEMS(id,id_ordered,quantity) VALUES (?, ?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ps.setString(2, String.valueOf(idOrdered));
			ps.setString(3, String.valueOf(quantity));
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert ordered items failed!");
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderedItem> getListByIdOrdered(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from OrDERED_ITEMS where ID_ORDERED=?";
		List<OrderedItem> list = new ArrayList<OrderedItem>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));

			rs = ps.executeQuery();

			while (rs.next()) {

				OrderedItem orderedItem = new OrderedItem();
				orderedItem.setProduct(productDaoImpl.get(Integer.valueOf(rs.getString("id"))));
				orderedItem.setIdOrdered(Integer.valueOf(rs.getString("ID_ORDERED")));
				orderedItem.setQuantity(Integer.valueOf(rs.getString("quantity")));
				list.add(orderedItem);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("get ordered items failed!");
			e.printStackTrace();
		}
		return null;
	}
}
