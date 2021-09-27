package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Bus;
import com.sunbeam.models.BusDTO;

public interface BusService {
	List<Bus> findAllByAgency(int id);
	
	Bus findByBusNo(String busNo);
	//boolean addBus(BusDto dto);
	Bus findByBusId(int id);
	boolean deleteBus(Bus bus);
	boolean addBus(BusDTO dto);
}
