package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
	      return new ResponseEntity<>("Problem occured !", HttpStatus.INTERNAL_SERVER_ERROR);
	   }

}
