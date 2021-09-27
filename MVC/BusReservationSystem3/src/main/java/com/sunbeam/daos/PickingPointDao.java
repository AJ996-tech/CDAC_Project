package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PickingPoint;

public interface PickingPointDao extends JpaRepository<PickingPoint, Integer>{
	
}
