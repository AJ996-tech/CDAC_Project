package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Agency;

public interface AgencyDao extends JpaRepository<Agency, Integer>{
	Agency findAgencyByEmail(String email);
	List<Agency> findAll();
	Agency findUserByEmail(String email);
}
