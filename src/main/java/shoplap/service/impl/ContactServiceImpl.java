package shoplap.service.impl;

import shoplap.dao.ContactDao;
import shoplap.dao.impl.ContactDaoImpl;
import shoplap.entity.Contact;

public class ContactServiceImpl implements ContactDao {
	ContactDaoImpl contactDaoImpl = new ContactDaoImpl();

	@Override
	public Contact get(int branch) {
		// TODO Auto-generated method stub

		return contactDaoImpl.get(branch);
	}

}
