package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Ticket;

public interface TicketService {
	List<Ticket> findAllBookings(int id);
	Ticket saveDetails(Ticket details);
}
