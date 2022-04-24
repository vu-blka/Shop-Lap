package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoplap.dao.MessageDao;
import shoplap.entity.Category;
import shoplap.entity.Message;
import shoplap.jdbc.connectDB;

public class MessageDaoImpl implements MessageDao {
	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	ResultSet rs;
	PreparedStatement ps;

	@Override
	public boolean insert(Message message) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO messages(name,mail,phone,subject,message,seen,date) VALUES (?, ?,?,?,?,0,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, message.getName().trim());
			ps.setString(2, message.getEmail().trim());
			ps.setString(3, message.getPhone().trim());
			ps.setString(4, message.getSubject().trim());
			ps.setString(5, message.getMsg().trim());
			ps.setString(6, message.getDate());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("insert message failed!");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> getAll() {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM Messages";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Message message = new Message();

				message.setIdMessage(rs.getString("id_message").trim());
				message.setName(rs.getString("name").trim());
				message.setEmail(rs.getString("mail").trim());
				message.setPhone(rs.getString("phone").trim());
				message.setSubject(rs.getString("subject").trim());
				message.setMsg(rs.getString("message").trim());
				message.setSeen(rs.getString("seen").trim());
				message.setDate(rs.getString("date").trim());
				list.add(message);
			}
		} catch (SQLException e) {
			System.out.println("get all message failed!");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Message> getUnSeen() {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM Messages where seen=0";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Message message = new Message();

				message.setIdMessage(rs.getString("id_message").trim());
				message.setName(rs.getString("name").trim());
				message.setEmail(rs.getString("mail").trim());
				message.setPhone(rs.getString("phone").trim());
				message.setSubject(rs.getString("subject").trim());
				message.setMsg(rs.getString("message").trim());
				message.setSeen(rs.getString("seen").trim());
				message.setDate(rs.getString("date").trim());
				list.add(message);
			}
		} catch (SQLException e) {
			System.out.println("get all message failed!");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Message> getSeen() {
		// TODO Auto-generated method stub
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM Messages where seen=1";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Message message = new Message();

				message.setIdMessage(rs.getString("id_message").trim());
				message.setName(rs.getString("name").trim());
				message.setEmail(rs.getString("mail").trim());
				message.setPhone(rs.getString("phone").trim());
				message.setSubject(rs.getString("subject").trim());
				message.setMsg(rs.getString("message").trim());
				message.setSeen(rs.getString("seen").trim());
				message.setDate(rs.getString("date").trim());
				list.add(message);
			}
		} catch (SQLException e) {
			System.out.println("get all message failed!");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Message get(String id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM Messages where id_message=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Message message = new Message();

				message.setIdMessage(rs.getString("id_message").trim());
				message.setName(rs.getString("name").trim());
				message.setEmail(rs.getString("mail").trim());
				message.setPhone(rs.getString("phone").trim());
				message.setSubject(rs.getString("subject").trim());
				message.setMsg(rs.getString("message").trim());
				message.setSeen(rs.getString("seen").trim());
				message.setDate(rs.getString("date").trim());
				return message;
			}
		} catch (SQLException e) {
			System.out.println("get message failed!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(String id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE messages SET seen = 1 WHERE id_message = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("edit message failed!");
			e.printStackTrace();
		}
		return false;
	}

}
