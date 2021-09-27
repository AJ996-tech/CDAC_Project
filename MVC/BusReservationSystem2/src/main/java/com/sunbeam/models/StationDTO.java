package com.sunbeam.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Bus;
import com.sunbeam.entities.Station;

@Component
public class StationDTO {
	private int stationId;
	private String name;
	private String address;
	private String city;

	public StationDTO() {
		// TODO Auto-generated constructor stub
	}

	public StationDTO(int stationId, String name, String address, String city) {
		this.stationId = stationId;
		this.name = name;
		this.address = address;
		this.city = city;
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

	@Override
	public String toString() {
		return "StationDTO [stationId=" + stationId + ", name=" + name + ", address=" + address + ", city=" + city
				+ "]";
	}

	public static StationDTO fromEntity(Station station) {
		StationDTO dto = new StationDTO();
		BeanUtils.copyProperties(station, dto);
		return dto;
	}
}
