package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Agency;
import com.sunbeam.entities.Trip;

public interface AgencyService {
	Agency findAgencyByEmail(String email);
	Agency authenticate(String email, String password);
	List<Agency> findAgencyAll();
	Agency saveAgency(Agency agency);
	boolean deleteById(int id);
	Agency findAgencyById(int id);
	List<Trip> findAllAgencyTrips(int agencyId);
	Agency findById(int agencyId);
	Agency save(Agency agency);
	Agency updatePassword(String email, String password);
	Agency updateAgency(Agency agency);
}
