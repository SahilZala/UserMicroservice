package com.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	
	@Query(value ="SELECT * FROM user u WHERE u.email_id = ?1",nativeQuery=true)
	public Optional<User> findByEmailId(String emailId);
	
}
