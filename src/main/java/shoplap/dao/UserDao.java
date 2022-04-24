package shoplap.dao;

import java.util.List;

import shoplap.entity.User;

public interface UserDao {
	boolean insert(User user);
	boolean edit (User user);
	boolean delete(User user);
	User get(String username);
	List<User> getAll();
}
