package shoplap.service;

import java.util.List;

import shoplap.entity.Cart;
import shoplap.entity.User;

public interface UserService {
	public boolean login(String username, String password);
	public boolean register(User user );
	User get(String username);
	boolean edit(User user);
	List<Cart> getCartsByUsername(String username);
}
