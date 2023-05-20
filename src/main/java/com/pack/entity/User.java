package com.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String id;
	@Column(unique=true)
	private String emailId;
	private String password;
	private String username;
	private String userType;
	private boolean activation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	private User(String id, String emailId, String password, String username, String userType, boolean activation) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.username = username;
		this.userType = userType;
		this.activation = activation;
	}
	private User() {
		super();
	}
}
