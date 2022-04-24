package shoplap.service;

import java.util.List;

import shoplap.entity.Admin;

public interface AdminService {
	
	public Admin checkLoginAdmin(String username, String password);
	public List<Admin> getAll();
	public boolean insert(Admin admin);
	public boolean edit(Admin admin);
	public Admin get(String username);
}
