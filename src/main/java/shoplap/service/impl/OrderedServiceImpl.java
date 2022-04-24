package shoplap.service.impl;

import shoplap.dao.impl.CartDaoImpl;
import shoplap.dao.impl.OrderedDaoImpl;
import shoplap.dao.impl.OrderedItemDaoImpl;
import shoplap.dao.impl.ProductDaoImpl;
import shoplap.entity.Cart;
import shoplap.entity.Ordered;
import shoplap.entity.Product;
import shoplap.service.OrderedService;

public class OrderedServiceImpl implements OrderedService {
	OrderedItemDaoImpl orderedItemDaoImpl = new OrderedItemDaoImpl();
	OrderedDaoImpl orderedDaoImpl = new OrderedDaoImpl();
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	CartDaoImpl cartDaoImpl = new CartDaoImpl();

	@Override
	public void insert(Ordered ordered, String username) {
		orderedDaoImpl.insert(ordered);
		Product product = new Product();
		for (int i = 0; i < ordered.getCart().size(); i++) {
			int id = ordered.getCart().get(i).getProduct().getId();

			Cart cart = cartDaoImpl.get(ordered.getCart().get(i).getProduct().getId(), username);
			int quantityOrdered = cart.getQuantity();

			orderedItemDaoImpl.insert(id, ordered.getIdOrdered(), quantityOrdered);

			product = productDaoImpl.get(ordered.getCart().get(i).getProduct().getId());
			product.setQuantity(product.getQuantity() - quantityOrdered);
			product.setQuantitySold(quantityOrdered + product.getQuantitySold());

			product.setId_cartegory(product.getCategory().getId());
			product.setId_brand(String.valueOf(product.getBrand().getId()));
			productDaoImpl.edit(product);
		}

	}

	@Override
	public void insertOrderedItem(int id, int idOrdered, int quantity) {
		orderedItemDaoImpl.insert(id, idOrdered, quantity);
		
	}

	@Override
	public int count() {
		System.out.println("ssss" + orderedDaoImpl.count());
		return orderedDaoImpl.count();
	}
}
