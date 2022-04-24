package shoplap.dao;

import java.util.List;

import shoplap.entity.Ordered;

public interface OrderedDao {

	void insert(Ordered ordered);

	int count();

	List<Ordered> getNull();
	List<Ordered> getNotNull();
	Ordered get(int id);
	
	boolean update(Ordered ordered);
}
