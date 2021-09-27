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
@Table(name = "substation")
public class SubStation {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "subStationId")
	private int subStationId;
	@Column(name = "name")
	private String subStationName;

	@ManyToOne
	@JoinColumn(name = "stationId")
	private Station station;

	public SubStation() {
		// TODO Auto-generated constructor stub
	}

	public SubStation(int subStationId, String subStationName, Station station) {
		this.subStationId = subStationId;
		this.subStationName = subStationName;
		this.station = station;
	}

	public int getSubStationId() {
		return subStationId;
	}

	public void setSubStationId(int subStationId) {
		this.subStationId = subStationId;
	}

	public String getSubStationName() {
		return subStationName;
	}

	public void setSubStationName(String subStationName) {
		this.subStationName = subStationName;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "SubStation [subStationId=" + subStationId + ", subStationName=" + subStationName + ", station="
				+ station + "]";
	}
}
