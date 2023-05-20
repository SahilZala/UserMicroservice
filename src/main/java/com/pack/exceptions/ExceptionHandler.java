package com.pack.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.pack.dao.Response;

@ControllerAdvice
public class ExceptionHandler {
	
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

	
	@org.springframework.web.bind.annotation.ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<Response> handleException(UserNotFoundException ex){
		log.info(ex.getMessage());
		return new ResponseEntity<>(new Response(HttpStatus.UNAUTHORIZED.value(),ex.getMessage(),null),HttpStatus.UNAUTHORIZED);
	}
	

	@org.springframework.web.bind.annotation.ExceptionHandler({SQLIntegrityConstraintViolationException.class})
	public ResponseEntity<Response> handleException(SQLIntegrityConstraintViolationException ex){
		log.info(ex.getMessage());
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),null),HttpStatus.UNAUTHORIZED);
	}
}
