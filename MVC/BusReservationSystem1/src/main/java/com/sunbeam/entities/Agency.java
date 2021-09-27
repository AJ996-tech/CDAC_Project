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
	private String agencyName;
	@Column(name = "ownerName")
	private String agencyOwnerName;
	@Column(name = "email")
	private String agencyEmail;
	@Column(name = "password")
	private String agencyPassword;
	@Column(name = "address")
	private String agencyAddress;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
	@OneToMany(mappedBy = "agency")
	private List<Bus> busList;
	
	public Agency() {
		// TODO Auto-generated constructor stub
	}

	public Agency(int agencyId, String agencyName, String agencyOwnerName, String agencyEmail, String agencyPassword,
			String agencyAddress, Admin admin, List<Bus> busList) {
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.agencyOwnerName = agencyOwnerName;
		this.agencyEmail = agencyEmail;
		this.agencyPassword = agencyPassword;
		this.agencyAddress = agencyAddress;
		this.admin = admin;
		this.busList = busList;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyOwnerName() {
		return agencyOwnerName;
	}

	public void setAgencyOwnerName(String agencyOwnerName) {
		this.agencyOwnerName = agencyOwnerName;
	}

	public String getAgencyEmail() {
		return agencyEmail;
	}

	public void setAgencyEmail(String agencyEmail) {
		this.agencyEmail = agencyEmail;
	}

	public String getAgencyPassword() {
		return agencyPassword;
	}

	public void setAgencyPassword(String agencyPassword) {
		this.agencyPassword = agencyPassword;
	}

	public String getAgencyAddress() {
		return agencyAddress;
	}

	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
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
		return "Agency [agencyId=" + agencyId + ", agencyName=" + agencyName + ", agencyOwnerName=" + agencyOwnerName
				+ ", agencyEmail=" + agencyEmail + ", agencyPassword=" + agencyPassword + ", agencyAddress="
				+ agencyAddress + ", admin=" + admin + ", busList=" + busList + "]";
	}
}
