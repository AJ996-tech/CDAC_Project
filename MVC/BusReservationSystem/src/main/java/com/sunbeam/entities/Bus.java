package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "busId")
	private int busId;
	@Column(name = "busNo")
	private String busNo;
	@Column(name = "type")
	private String busType;
	@Column(name = "model")
	private String busModel;

	@ManyToOne
	@JoinColumn(name = "agencyId")
	private Agency agency;
	@OneToMany(mappedBy = "bus")
	private List<Seat> seatList;
	@OneToOne(mappedBy = "bus")
	private Booking booking;
}
