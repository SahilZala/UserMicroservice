package com.pack.dto;

import java.util.List;

import com.pack.entity.User;

public interface UserDTO {
	public User createNewUser(User user);
	public List<User> getAllUser();
	public User findByUserId(String id);
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPasssword(String emailId,String password);
}