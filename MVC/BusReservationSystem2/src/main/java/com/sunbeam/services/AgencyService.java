package com.sunbeam.services;

import com.sunbeam.entities.Agency;

public interface AgencyService {
	Agency findAgencyByEmail(String email);
	Agency authenticate(String email, String password);
}
