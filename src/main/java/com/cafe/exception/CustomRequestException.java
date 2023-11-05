package com.cafe.exception;

public class CustomRequestException extends Exception{
	public CustomRequestException(String message) {
		//super(message);
		System.out.println("error message : " + message);
		
	}
}
