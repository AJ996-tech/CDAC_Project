package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Admin;

@Component
public class AdminDTO {
	private int adminId;
	private String name;
	private String email;
	private String password;
	
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(int adminId, String name, String email, String password) {
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	public AdminDTO fromEntity(Admin admin) {
		AdminDTO dto = new AdminDTO();
		BeanUtils.copyProperties(admin, dto);
		return dto;
	}
}
