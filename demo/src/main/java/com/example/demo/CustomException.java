package com.example.demo;

public class CustomException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public CustomException() {
     super();
	}
	
	public CustomException(String msg) {
	     super(msg);
		}
	
	public CustomException(String msg,Throwable t) {
	     super(t);
		}
	
	public static void main(String[] args) throws CustomException {
		throw new CustomException("custom e");
	}
}
