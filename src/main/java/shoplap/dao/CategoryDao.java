package shoplap.dao;

import java.util.List;

import shoplap.entity.Category;


public interface CategoryDao {
	boolean insert(Category category);

	boolean edit(Category category);

	boolean delete(String id);

	Category get(String id);

	List<Category> getAll();
	
	Category getCategoryByIdProduct(int id);
}
