package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Seat;
import com.sunbeam.entities.Ticket;
import com.sunbeam.entities.Trip;
import com.sunbeam.entities.User;
import com.sunbeam.models.PaymentDTO;
import com.sunbeam.models.Response;
import com.sunbeam.models.TicketDTO;
import com.sunbeam.services.TicketService;
import com.sunbeam.services.TripService;
import com.sunbeam.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserService userService;
	@Autowired
	private TripService tripService;
	
	@PostMapping("/details")
	public ResponseEntity<?> details(PaymentDTO dto){
		System.out.println(dto);
		TicketDTO tdto = new TicketDTO();
		List<Seat> list = new ArrayList<Seat>();
		List<Integer> sNo = new ArrayList<>();
		Ticket details = new Ticket();
		User user = userService.findUserById(dto.getUserId());
		Trip trip = tripService.findTripById(dto.getTripId());
		if(user != null)
			details.setUser(user);
		if(trip != null)
			details.setTrip(trip);
		String[] seats = dto.getSeatNumber();
		for (String seat : seats) {
			int seatNo = Integer.parseInt(seat);
			Seat s = new Seat();
			s.setSeatNo(seatNo);
			s.setBooked(1);
			s.setTicket(details);
			s.setTrip(trip);
			list.add(s);
			sNo.add(s.getSeatNo());
		}
		details.setPickingPoint(dto.getPickingPoint());
		details.setDroppingPoint(dto.getDroppingPoint());
		details.setSeatList(list);
		Ticket ticket = ticketService.saveDetails(details);
		
		
		tdto.setName(user.getFirstName() + " " + user.getLastName());
		tdto.setPickingPoint(dto.getPickingPoint());
		tdto.setDroppingPoint(dto.getDroppingPoint());
		tdto.setBusNo(trip.getBus().getBusNo());
		tdto.setDate(trip.getDate());
		tdto.setFromStation(trip.getFromStation());
		tdto.setToStation(trip.getToStation());
		tdto.setTicketId(ticket.getTicketId());
		tdto.setTicketPrice(trip.getTicketPrice());
		tdto.setSeatNo(sNo);
	
		if(tdto != null)
				return Response.success(tdto);
		return Response.error("Payment Failed!");
	}
}
