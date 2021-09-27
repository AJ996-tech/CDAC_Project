package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "substation")
public class SubStation {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "subStationId")
	private int subStationId;
	@Column(name = "name")
	private String subStationName;

}
