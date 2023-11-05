package com.cafe.exceptionHandler;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException() {
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.SERVER_ERROR,""),HttpStatus.OK);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFound() {
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.DATA_NOT_FOUND,""),HttpStatus.OK);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleParameterError(HttpMessageNotReadableException e) {
		System.out.println("HttpMessageNotReadableException Error : " + e.getMessage());
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.PARAMETER_ERROR,""),HttpStatus.OK);
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<ErrorResponse> handleNoAcceptableRepresentation(HttpMediaTypeNotAcceptableException e){
		System.out.println("HttpMediaTypeNotAcceptableException Error : " + e.getMessage());
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.NO_ACCEPTABLE_REPRESENTATION,""),HttpStatus.OK);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e){
		System.out.println("HttpMediaTypeNotAcceptableException Error : " + e.getMessage());
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED,""),HttpStatus.OK);
	}
}
