package com.sunbeam.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AgencyDao;
import com.sunbeam.entities.Agency;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService{
	@Autowired
	private AgencyDao agencyDao;

	@Override
	public Agency findAgencyByEmail(String email) {
		Agency agency = agencyDao.findAgencyByEmail(email);
		return agency;
	}

	@Override
	public Agency authenticate(String email, String password) {
		Agency agency = agencyDao.findAgencyByEmail(email);
		if(agency != null && agency.getPassword().equals(password))
			return agency;
		return null;
	}
	
}
