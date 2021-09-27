package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Trip;
import com.sunbeam.models.EditTripDTO;

public interface TripService {
	List<Trip> findAllTrip();
	List<Trip> findByRoute(String fromStation, String toStation, String date);
	Trip findTripById(int tripId);
	List<Trip> findAll();
	Trip findById(int id);
	boolean deleteTrip(Trip trip);
	boolean update(int id, EditTripDTO dto);
	boolean addNewTrip(EditTripDTO dto);
}
