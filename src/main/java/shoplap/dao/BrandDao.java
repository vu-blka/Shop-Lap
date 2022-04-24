package shoplap.dao;

import java.util.List;

import shoplap.entity.Brand;

public interface BrandDao {
	boolean insert(Brand brand);

	boolean edit(Brand brand);

	boolean delete(int id);

	Brand get(int id);
	Brand getBrandByIdProduct(int id);
	List<Brand> getAll();
	
	List<Brand> getPopularBrand();
}
