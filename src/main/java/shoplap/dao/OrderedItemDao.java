package shoplap.dao;

import java.util.List;

import shoplap.entity.OrderedItem;

public interface OrderedItemDao {



	void insert(int id, int idOrdered, int quantity);
	
	List<OrderedItem> getListByIdOrdered(int id);
}
