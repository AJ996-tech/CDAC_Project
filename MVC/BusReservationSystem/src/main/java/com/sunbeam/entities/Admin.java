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
}
