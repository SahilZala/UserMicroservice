package com.pack.dto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dto.UserDTO;
import com.pack.entity.User;
import com.pack.exceptions.UserNotFoundException;
import com.pack.service.UserService;
import com.pack.util.AppUtility;

@Service
public class UserDTOImpl implements UserDTO{

	
	@Autowired
	UserService userService;
	
	@Override
	public User createNewUser(User user) {
		user.setId(AppUtility.getRandomeId());
		return userService.createUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@Override
	public User findByUserId(String id) {
		return userService.getUserById(id);
	}

	@Override
	public User findByEmailId(String emailId) {
		return userService.getUserByEmailId(emailId);
	}

	@Override
	public User findByEmailIdAndPasssword(String emailId, String password) {
		User user = userService.getUserByEmailId(emailId);
		if(user.getPassword().equals(password))
			return user;
		throw new UserNotFoundException("Invalid username and password");
	}
}
