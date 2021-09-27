package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.User;

public interface UserService {
	User save(User user);
	User authenticate(String email, String password);
	User findUserByEmail(String email);
	User updatePassword(String email, String password);
	User updateUser(User user);
	User findUserById(int id);
	List<User> findUserAll();
	boolean deleteById(int id);
}
