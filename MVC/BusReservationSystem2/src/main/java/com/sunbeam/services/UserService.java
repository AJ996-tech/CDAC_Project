package com.sunbeam.services;

import com.sunbeam.entities.User;
import com.sunbeam.models.UserDTO;

public interface UserService {
	User save(User user);
	User authenticate(String email, String password);
	User findUserByEmail(String email);
	User updatePassword(String email, String password);
}
