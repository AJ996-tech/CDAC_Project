package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer>{
	
}
