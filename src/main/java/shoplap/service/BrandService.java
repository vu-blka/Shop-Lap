package shoplap.service;

import java.util.List;

import shoplap.entity.Brand;

public interface BrandService {
	String getQuantitySoldByBrand(int id);
	int getCountProductByBrand(int id);
	List<Brand> getAll();
}
