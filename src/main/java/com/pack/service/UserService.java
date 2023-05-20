package com.pack.service;

import java.util.List;

import com.pack.entity.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUser();
	public User getUserById(String id);
	public User getUserByEmailId(String emailId);
}
