package com.sunbeam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Admin;
import com.sunbeam.entities.User;
import com.sunbeam.models.AdminDTO;
import com.sunbeam.models.CredentialsDTO;
import com.sunbeam.models.Response;
import com.sunbeam.services.AdminService;

@CrossOrigin
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminDTO dto;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginAdmin(@Valid CredentialsDTO cred){;
		Admin admin = adminService.authenticate(cred.getEmail(), cred.getPassword());
		AdminDTO a = dto.fromEntity(admin);
		if(a != null) {
			System.out.println(a);
			return Response.success(a);
		}
		return Response.error("Login Failed!");
	}
}
