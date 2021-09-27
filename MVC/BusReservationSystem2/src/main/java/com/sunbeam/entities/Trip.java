package com.sunbeam.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "trip")
public class Trip {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "tripId")
	private int tripId;
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	@Column(name = "arrivalTime")
	private String arrivalTime;
	@Column(name = "departureTime")
	private String departureTime;
	@Column(name = "ticketPrice")
	private double ticketPrice;

	@ManyToOne
	@JoinColumn(name = "busId")
	private Bus bus;

	@OneToMany(mappedBy = "trip")
	private List<Ticket> ticketList;

	@OneToMany(mappedBy = "trip")
	private List<Station> stationList;

	public Trip() {
		// TODO Auto-generated constructor stub
	}

	public Trip(int tripId, Date date, String arrivalTime, String departureTime, double ticketPrice, Bus bus,
			List<Ticket> ticketList, List<Station> stationList) {
		this.tripId = tripId;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.ticketPrice = ticketPrice;
		this.bus = bus;
		this.ticketList = ticketList;
		this.stationList = stationList;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", date=" + date + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", ticketPrice=" + ticketPrice + ", bus=" + bus + ", ticketList=" + ticketList
				+ ", stationList=" + stationList + "]";
	}
}
