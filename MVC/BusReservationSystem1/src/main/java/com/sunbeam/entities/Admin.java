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
	private String adminName;
	@Column(name = "email")
	private String adminEmail;
	@Column(name = "password")
	private String adminPassword;

	@OneToMany(mappedBy = "admin")
	private List<Agency> agencyList;

	@OneToMany(mappedBy = "admin")
	private List<User> userList;

	@OneToMany(mappedBy = "admin")
	private List<Station> stationList;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminName, String adminEmail, String adminPassword, List<Agency> agencyList,
			List<User> userList, List<Station> stationList) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
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
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + ", agencyList=" + agencyList + ", userList=" + userList
				+ ", stationList=" + stationList + "]";
	}
}
