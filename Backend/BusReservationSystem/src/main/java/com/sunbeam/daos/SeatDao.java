package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Seat;

public interface SeatDao extends JpaRepository<Seat, Integer>{

}
