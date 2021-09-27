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
//	@OneToMany(mappedBy = "user")
//	private List<Integer> ticketList;
	
}
