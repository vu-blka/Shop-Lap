package shoplap.service.impl;

import java.util.List;

import shoplap.dao.impl.PaymentDaoImpl;
import shoplap.dao.impl.ShippingDaoImpl;
import shoplap.entity.Payment;
import shoplap.entity.Shipping;
import shoplap.service.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService{
	ShippingDaoImpl shippingDaoImpl=new ShippingDaoImpl();
	PaymentDaoImpl paymentDaoImpl=new PaymentDaoImpl();
	@Override
	public List<Shipping> getAllShipping() {
		// TODO Auto-generated method stub
		return shippingDaoImpl.getAll();
	}
	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentDaoImpl.getAll();
	}
	
}
