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
@Table(name = "user")
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "userId")
	private int userId;
	@Column(name = "firstName")
	private String userFirstName;
	@Column(name = "lastName")
	private String userLastName;
	@Column(name = "mobileNo")
	private String mobileNo;
	@Column(name = "email")
	private String userEmail;
	@Column(name = "password")
	private String userPassword;
	@Column(name = "gender")
	private String gender;
	@Column(name = "address")
	private String userAddress;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	@OneToMany(mappedBy = "user")
	private List<Ticket> ticketList;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userFirstName, String userLastName, String mobileNo, String userEmail,
			String userPassword, String gender, String userAddress, Admin admin, List<Ticket> ticketList) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.mobileNo = mobileNo;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.gender = gender;
		this.userAddress = userAddress;
		this.admin = admin;
		this.ticketList = ticketList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", mobileNo=" + mobileNo + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", gender="
				+ gender + ", userAddress=" + userAddress + ", admin=" + admin + ", ticketList=" + ticketList + "]";
	}
}
