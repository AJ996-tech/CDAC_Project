package com.sunbeam.services;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.Admin;
import com.sunbeam.entities.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		return user;
	}

	@Override
	public User save(User user) {
		String encPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encPassword);
		user.setAdmin(Admin.getInstance());
		return userDao.save(user);
	}

	@Override
	public User authenticate(String email, String password) {
		User user = findUserByEmail(email);
		if (user != null && passwordEncoder.matches(password, user.getPassword()))
			return user;
		return null;
	}

	@Override
	public User updatePassword(String email, String password) {
		User user = this.findUserByEmail(email);
		if (user != null) {
			user.setPassword(password);
			return this.save(user);
		}
		return null;
	}
}