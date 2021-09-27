package com.sunbeam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Agency;
import com.sunbeam.models.AgencyDTO;
import com.sunbeam.models.CredentialsDTO;
import com.sunbeam.models.Response;
import com.sunbeam.services.AgencyService;

@CrossOrigin
@RequestMapping("/agency")
@RestController
public class AgencyController {
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private AgencyDTO dto;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginAgency(@Valid CredentialsDTO cred){;
		Agency admin = agencyService.authenticate(cred.getEmail(), cred.getPassword());
		AgencyDTO a = dto.fromEntity(admin);
		if(a != null) {
			System.out.println(a);
			return Response.success(a);
		}
		return Response.error("Login Failed!");
	}
}
