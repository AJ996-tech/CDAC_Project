package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Trip;

public interface TripDao extends JpaRepository<Trip, Integer>{
	
}
