package shoplap.service;

import java.util.List;

import shoplap.entity.Payment;
import shoplap.entity.Shipping;

public interface CheckoutService {
	List<Shipping> getAllShipping();
	List<Payment> getAllPayment();
}
