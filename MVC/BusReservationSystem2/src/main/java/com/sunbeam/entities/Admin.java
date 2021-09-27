package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "adminId")
	private int adminId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "admin")
	private List<Agency> agencyList;

	@OneToMany(mappedBy = "admin")
	private List<User> userList;

	@OneToMany(mappedBy = "admin")
	private List<Station> stationList;

	public Admin() {
		this.adminId = 1;
		this.name = "Admin";
		this.email = "admin@gmail.com";
		this.password = "admin";
	}

	public Admin(int adminId, String name, String email, String password, List<Agency> agencyList, List<User> userList,
			List<Station> stationList) {
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.agencyList = agencyList;
		this.userList = userList;
		this.stationList = stationList;
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

	public List<Agency> getAgencyList() {
		return agencyList;
	}

	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", agencyList=" + agencyList + ", userList=" + userList + ", stationList=" + stationList + "]";
	}
	
	public static Admin adminInstance = null;
	
	public static Admin getInstance() {
		if(adminInstance == null)
			adminInstance = new Admin();
		adminInstance.setName("Admin");
		adminInstance.setEmail("admin@gmail.com");
		adminInstance.setPassword("admin");
		return adminInstance;
	}
}