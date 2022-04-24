package shoplap.service.impl;

import java.util.List;

import shoplap.dao.impl.BillDaoImpl;
import shoplap.dao.impl.OrderedItemDaoImpl;
import shoplap.dao.impl.PaymentDaoImpl;
import shoplap.dao.impl.ShippingDaoImpl;
import shoplap.entity.Bill;
import shoplap.entity.OrderedItem;
import shoplap.entity.Payment;
import shoplap.entity.Shipping;
import shoplap.service.BillService;

public class BillServiceImpl implements BillService {
	PaymentDaoImpl paymentDaoImpl = new PaymentDaoImpl();
	ShippingDaoImpl shippingDaoImpl = new ShippingDaoImpl();
	BillDaoImpl billDaoImpl = new BillDaoImpl();
	OrderedItemDaoImpl orderedItemDaoImpl = new OrderedItemDaoImpl();

	@Override
	public int count() {
		return billDaoImpl.count();
	}

	@Override
	public void insert(Bill bill) {
		billDaoImpl.insert(bill);
	}

	@Override
	public Bill get(int id) {
		return billDaoImpl.get(id);
	}

	@Override
	public boolean update(Bill bill) {
		try {
			billDaoImpl.update(bill);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public List<OrderedItem> getOrderedItemInBill(int id) {
		// TODO Auto-generated method stub

		return orderedItemDaoImpl.getListByIdOrdered(id);
	}
}
