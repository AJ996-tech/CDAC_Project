package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agency")
public class Agency {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "agencyId")
	private int agencyId;
	@Column(name = "name")
	private String name;
	@Column(name = "ownerName")
	private String ownerName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	@OneToMany(mappedBy = "agency")
	private List<Bus> busList;
	
	public Agency() {
		// TODO Auto-generated constructor stub
	}

	public Agency(int agencyId, String name, String ownerName, String email, String password, String address,
			Admin admin, List<Bus> busList) {
		this.agencyId = agencyId;
		this.name = name;
		this.ownerName = ownerName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.admin = admin;
		this.busList = busList;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Bus> getBusList() {
		return busList;
	}

	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}

	@Override
	public String toString() {
		return "Agency [agencyId=" + agencyId + ", name=" + name + ", ownerName=" + ownerName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", admin=" + admin + ", busList=" + busList + "]";
	}
}
