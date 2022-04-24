package shoplap.dao;

import java.util.List;

import shoplap.entity.Review;

public interface ReviewDao {

	void insert(Review review);

	List<Review> getAll();

	List<Review> getReviewByIdProduct(int id);
}
