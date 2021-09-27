package com.sunbeam.services;

import com.sunbeam.entities.Admin;

public interface AdminService {
	Admin findAdminByEmail(String email);
	Admin authenticate(String email, String password);
}
