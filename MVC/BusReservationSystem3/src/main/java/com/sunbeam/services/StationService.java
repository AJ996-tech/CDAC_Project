package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Station;

public interface StationService {
	List<Station> findAllStation();
	Station saveStation(Station station);
	List<Station> findStationAll();
	boolean deleteById(int id);
	List<String> findAll();
}
