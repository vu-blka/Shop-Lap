package shoplap.service;

import shoplap.entity.Ordered;

public interface OrderedService {

	int count();

	void insert(Ordered ordered, String username);

	void insertOrderedItem(int id, int idOrdered, int quantity);

}
