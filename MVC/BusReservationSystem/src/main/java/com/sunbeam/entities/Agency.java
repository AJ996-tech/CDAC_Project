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
	
	
}
