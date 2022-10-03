package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
	      return new ResponseEntity<>("Problem occured !", HttpStatus.INTERNAL_SERVER_ERROR);
	   }

	@ExceptionHandler(value=CustomException.class)
	public void exception(CustomException e) {
		System.out.println("CustomException-@ControllerAdvice");
	    //  return new ResponseEntity<>("Problem occured !", HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	
	@Override
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 return handleExceptionInternal(ex, ex, headers, status, request);
	}
}
