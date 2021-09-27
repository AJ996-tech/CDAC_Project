package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Route;

public interface RouteDao extends JpaRepository<Route, Integer>{
	
}
