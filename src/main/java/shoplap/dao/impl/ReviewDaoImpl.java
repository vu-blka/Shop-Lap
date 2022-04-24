package shoplap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shoplap.dao.ReviewDao;
import shoplap.entity.Review;
import shoplap.jdbc.connectDB;

public class ReviewDaoImpl implements ReviewDao {

	connectDB connectDB = new connectDB();
	Connection conn = shoplap.jdbc.connectDB.getConnect();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void insert(Review review) {
		String sql = "INSERT INTO reviews(id, username, title, star, content, createAt) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(review.getIdProduct()));
			ps.setString(2, review.getUsername());
			ps.setString(3, review.getTitle());
			ps.setString(4, review.getStar());
			ps.setString(5, review.getContent());
			ps.setString(6, review.getCreateAt());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error insert review");
		}
	}

	@Override
	public List<Review> getAll() {
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * FROM reviews";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setId(Integer.valueOf(rs.getString("id")));
				review.setIdProduct(Integer.valueOf(rs.getString("id_review")));
				review.setTitle(rs.getString("username"));
				review.setTitle(rs.getString("title"));
				review.setStar(rs.getString("star"));
				review.setContent(rs.getString("content"));
				review.setCreateAt(rs.getString("createAt"));

				reviews.add(review);
			}
		} catch (SQLException e) {
			System.out.println("error get all review");
		}
		return null;
	}

	@Override
	public List<Review> getReviewByIdProduct(int id) {
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * FROM REVIEWS WHERE id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setId(Integer.valueOf(rs.getString("id_review")));
				review.setIdProduct(Integer.valueOf(rs.getString("id")));
				review.setUsername(rs.getString("username"));
				review.setTitle(rs.getString("title"));
				review.setStar(rs.getString("star"));
				review.setContent(rs.getString("content"));
				review.setCreateAt(rs.getString("createAt").split(" ")[0]);

				reviews.add(review);
			}
			return reviews;
		} catch (SQLException e) {
			System.out.println("error get review by id product");
		}
		return null;
	}

}
