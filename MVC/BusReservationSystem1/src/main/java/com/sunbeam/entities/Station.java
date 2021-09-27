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

	@ManyToOne
	@JoinColumn(name = "adminId")
	private Admin admin;

	@OneToMany(mappedBy = "station")
	private List<SubStation> subStationList;

	@ManyToOne
	@JoinColumn(name = "tripId")
	private Trip trip;

	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(int stationId, String stationName, String stationAddress, String stationCity, Admin admin,
			List<SubStation> subStationList, Trip trip) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationAddress = stationAddress;
		this.stationCity = stationCity;
		this.admin = admin;
		this.subStationList = subStationList;
		this.trip = trip;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationAddress() {
		return stationAddress;
	}

	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}

	public String getStationCity() {
		return stationCity;
	}

	public void setStationCity(String stationCity) {
		this.stationCity = stationCity;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<SubStation> getSubStationList() {
		return subStationList;
	}

	public void setSubStationList(List<SubStation> subStationList) {
		this.subStationList = subStationList;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", stationAddress=" + stationAddress
				+ ", stationCity=" + stationCity + ", admin=" + admin + ", subStationList=" + subStationList + ", trip="
				+ trip + "]";
	}
}
