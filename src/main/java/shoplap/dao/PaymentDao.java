package shoplap.dao;
import java.util.List;

import shoplap.entity.Payment;
public interface PaymentDao {
	List<Payment> getAll();
	Payment get(int idPayment);
	boolean insert(Payment payment);
	boolean update(Payment payment);
	boolean delete(int id);
}
