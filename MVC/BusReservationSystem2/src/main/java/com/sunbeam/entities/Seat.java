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
@Table(name = "seat")
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
	@JoinColumn(name = "busId")
	private Bus bus;

	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(int seatId, String passengerName, String passengerAge, String passengerGender, Bus bus) {
		this.seatId = seatId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.bus = bus;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", passengerGender=" + passengerGender + ", bus=" + bus + "]";
	}
}
