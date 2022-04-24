package shoplap.dao;

import shoplap.entity.Bill;
//doi tuong chua cac phuong thuc tuong tac db - table bill
public interface BillDao {
	void insert(Bill bill);

	Bill get(int idBill);

	int count();

	void update(Bill bill);
	
}
