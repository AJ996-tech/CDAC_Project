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
@Table(name="seat")
public class Seat {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "seatId")
	private int seatId;
	@Column(name = "name")
	private String passengerName;
	@Column(name = "age")
	private String passengerAge;
	@Column(name = "gender")
	private String passengerGender;
	
	@ManyToOne
	@JoinColumn(name="busId")
	private Bus bus;
}
