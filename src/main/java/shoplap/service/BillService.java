package shoplap.service;

import java.util.List;

import shoplap.entity.Bill;
import shoplap.entity.OrderedItem;

public interface BillService {

	int count();

	void insert(Bill bill);

	Bill get(int id);

	boolean update(Bill bill);
	
	List<OrderedItem> getOrderedItemInBill(int id);
}
