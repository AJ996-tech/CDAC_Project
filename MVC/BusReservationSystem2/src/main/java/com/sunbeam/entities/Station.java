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
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;

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

	public Station(int stationId, String name, String address, String city, Admin admin,
			List<SubStation> subStationList, Trip trip) {
		this.stationId = stationId;
		this.name = name;
		this.address = address;
		this.city = city;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
		return "Station [stationId=" + stationId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", admin=" + admin + ", subStationList=" + subStationList + ", trip=" + trip + "]";
	}
}
