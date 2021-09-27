package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Bus;

public interface BusDao extends JpaRepository<Bus, Integer>{
	List<Bus> findAll();
	public Bus findByBusNo(String busNo);
}
