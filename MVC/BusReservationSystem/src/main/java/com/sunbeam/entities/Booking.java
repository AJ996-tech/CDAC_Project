package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "tripId")
	private int tripId;
	@Column(name = "fromStationId")
	private int fromStationId;
	@Column(name = "toStationId")
	private int toStationId;
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	@Column(name = "arrivalTime")
	private String arrivalTime;
	@Column(name = "departureTime")
	private String departureTime;
	@Column(name = "ticketPrice")
	private double ticketPrice;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Bus bus;
}
