package shoplap.service.impl;

import java.util.ArrayList;
import java.util.List;

import shoplap.dao.impl.CartDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.entity.Cart;
import shoplap.entity.Product;
import shoplap.service.AddToCartService;

public class AddToCartServiceImpl implements AddToCartService {
	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@Override
	public boolean addToCart(Cart cart) {
		// TODO Auto-generated method stub
		Product product = productDaoImpl.get(cart.getProduct().getId());
		if (product.getQuantity() == 0) {
			return false;
		}
		if (cartDaoImpl.get(cart.getProduct().getId(), cart.getUsername()) == null) {
			cartDaoImpl.insert(cart);
		} else {
			Cart currentCart = cartDaoImpl.get(cart.getProduct().getId(), cart.getUsername());
			int quantity = currentCart.getQuantity() + cart.getQuantity();
			if (quantity > product.getQuantity()) {
				quantity = product.getQuantity();
			}
			Cart newCart = new Cart(cart.getProduct(), cart.getUsername(), quantity);
			cartDaoImpl.update(newCart);
		}
		return true;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		Product product = productDaoImpl.get(cart.getProduct().getId());
		if (product.getQuantity() == 0) {
			return false;
		}
		System.out.println("quantity trong service:" + cart.getProduct().getQuantity());
		if (product.getQuantity() < cart.getQuantity()) {
			cart.setQuantity(product.getQuantity());
		}

		cartDaoImpl.update(cart);
		return true;
	}
	@Override
	public void delete(Cart cart) {
		cartDaoImpl.delete(cart);
	}

	@Override
	public String show(String username) {
		// TODO Auto-generated method stub
		List<Cart> list = cartDaoImpl.getCartsByUsername(username);
		if(list==null) {
			System.out.println("show : 0");
			return "0";
		}
			
		else return String.valueOf(list.size());
	}

}
