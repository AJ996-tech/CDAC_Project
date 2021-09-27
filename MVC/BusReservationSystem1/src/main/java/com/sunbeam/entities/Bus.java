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
@Table(name = "bus")
public class Bus {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "busId")
	private int busId;
	@Column(name = "busNo")
	private String busNo;
	@Column(name = "type")
	private String busType;
	@Column(name = "model")
	private String busModel;

	@ManyToOne
	@JoinColumn(name = "agencyId")
	private Agency agency;
	
	@OneToMany(mappedBy = "bus")
	private List<Seat> seatList;
	
	@OneToMany(mappedBy = "bus")
	private List<Trip> tripList;
	
	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(int busId, String busNo, String busType, String busModel, Agency agency, List<Seat> seatList,
			List<Trip> tripList) {
		this.busId = busId;
		this.busNo = busNo;
		this.busType = busType;
		this.busModel = busModel;
		this.agency = agency;
		this.seatList = seatList;
		this.tripList = tripList;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusModel() {
		return busModel;
	}

	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}

	public List<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(List<Trip> tripList) {
		this.tripList = tripList;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNo=" + busNo + ", busType=" + busType + ", busModel=" + busModel
				+ ", agency=" + agency + ", seatList=" + seatList + ", tripList=" + tripList + "]";
	}
}
