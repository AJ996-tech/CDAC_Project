package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class Station {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "stationId")
	private int stationId;
	@Column(name = "name")
	private String stationName;
	@Column(name = "address")
	private String stationAddress;
	@Column(name = "city")
	private String stationCity;
	@Column(name = "pinCode")
	private String stationPinCode;

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;
}
