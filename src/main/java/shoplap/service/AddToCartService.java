package shoplap.service;

import shoplap.entity.Cart;

public interface AddToCartService {
	boolean addToCart(Cart cart);

	boolean updateCart(Cart cart);

	void delete(Cart cart);
	
	String show(String username);
}
