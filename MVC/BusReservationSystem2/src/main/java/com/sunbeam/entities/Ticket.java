package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ticketId")
	private int ticketId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "tripId")
	private Trip trip;

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticketId, User user, Trip trip) {
		this.ticketId = ticketId;
		this.user = user;
		this.trip = trip;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", user=" + user + ", trip=" + trip + "]";
	}
}
