package shoplap.dao;

import java.util.List;

import shoplap.entity.Shipping;

public interface ShippingDao {
	List<Shipping> getAll();
	Shipping get(int idShipping);
	boolean insert(Shipping shipping);
	boolean update(Shipping shipping);
	boolean delete(int id);
}
