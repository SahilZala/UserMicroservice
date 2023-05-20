package com.pack.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.Response;
import com.pack.dto.UserDTO;
import com.pack.entity.User;
import com.pack.util.APIPaths;

@RestController
@CrossOrigin
@RequestMapping("user_microservice")
public class UserController {

	@Autowired
	UserDTO userDTO;
	
	@PostMapping(APIPaths.CREATE)
	public ResponseEntity<Response> createUser(@RequestBody User user)
	{
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"no error",userDTO.createNewUser(user)),HttpStatus.OK);
	}
	
	@GetMapping(APIPaths.GET_ALL)
	public ResponseEntity<Response> getAllUser()
	{
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"no error",userDTO.getAllUser()),HttpStatus.OK);
	}
	
	@GetMapping(APIPaths.GET_BY_EMAILID+"/{emailId}")
	public ResponseEntity<Response> getByEmailId(@PathVariable String emailId)
	{
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"no error",userDTO.findByEmailId(emailId)),HttpStatus.OK);
	}
	
	@GetMapping(APIPaths.GET_BY_EMAILID_AND_PASSWORD)
	public ResponseEntity<Response> getByEmailIdAndPassword(@RequestParam String emailId,@RequestParam String password)
	{
		return new ResponseEntity<>(new Response(HttpStatus.OK.value(),"no error",userDTO.findByEmailIdAndPasssword(emailId,password)),HttpStatus.OK);
	}
	
}
