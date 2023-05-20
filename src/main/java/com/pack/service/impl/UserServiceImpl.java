package com.pack.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.User;
import com.pack.exceptions.UserNotFoundException;
import com.pack.repository.UserRepository;
import com.pack.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}
	@Override
	public User getUserById(String id) {
		
		Optional<User> u = userRepo.findById(id);
		if(u.isEmpty())
			throw new UserNotFoundException("user not found");
		return u.get();
	}
	@Override
	public User getUserByEmailId(String emailId) {
		
		Optional<User> u =  userRepo.findByEmailId(emailId);
		if(u.isEmpty())
			throw new UserNotFoundException("user not found");
		return u.get();
		
	}
}
