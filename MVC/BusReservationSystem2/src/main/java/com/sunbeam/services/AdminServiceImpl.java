package com.sunbeam.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AdminDao;
import com.sunbeam.entities.Admin;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin findAdminByEmail(String email) {
		Admin admin = adminDao.findAdminByEmail(email);
		return admin;
	}

	@Override
	public Admin authenticate(String email, String password) {
		Admin admin = adminDao.findAdminByEmail(email);
		if(admin != null && admin.getPassword().equals(password))
			return admin;
		return null;
	}
	
	
}
