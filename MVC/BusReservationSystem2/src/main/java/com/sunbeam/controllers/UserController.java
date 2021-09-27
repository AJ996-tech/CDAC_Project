package com.sunbeam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.User;
import com.sunbeam.models.CredentialsDTO;
import com.sunbeam.models.Response;
import com.sunbeam.models.UserDTO;
import com.sunbeam.services.UserService;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDTO dto;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody CredentialsDTO cred) {
		System.out.println(cred);
		User user = userService.authenticate(cred.getEmail(), cred.getPassword());
		if (user != null) {
			System.out.println(user);
			return Response.success(user);
		}
		return Response.error("Login Failed!");
	}

	@PostMapping("/register")
	public ResponseEntity<?> signup( UserDTO user) {
		User u = dto.toEntity(user);
		User u1 = userService.save(u);
		UserDTO dto = user.fromEntity(u1);
		if (dto != null)
			return Response.success(dto);
		return Response.error("Registration Failed!");
	}

	@PostMapping("/forgot")
	public ResponseEntity<?> changePassword(@Valid @RequestBody CredentialsDTO cred) {
		System.out.println(cred);
		User user = userService.updatePassword(cred.getEmail(), cred.getPassword());
		if (user != null) {
			System.out.println(user);
			return Response.success(user);
		}
		return Response.error(user);
	}
}
