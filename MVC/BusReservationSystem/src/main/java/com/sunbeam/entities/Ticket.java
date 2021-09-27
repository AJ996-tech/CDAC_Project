package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ticketId")
	private int ticketId;
	@Column(name = "price")
	private double totalTicketPrice;
	
//	@ManyToOne
//	@JoinColumn(name = "userId")
//	private User user;
	@OneToMany(mappedBy = "seat")
	private List<Integer> seatList;
}
