package shoplap.dao;

import java.util.List;

import shoplap.entity.Cart;

public interface CartDao {
	void insert(Cart cart);
	void update(Cart cart);
	void delete(Cart cart);
	Cart get(int idProduct, String username);
	List<Cart> getCartsByUsername(String username);
}
