package com.cafe.entity;

import lombok.Getter;

@Getter
public enum ErrorCode {
	OK("","errorNone"),
	NO_CONTENT("","errorNone"),
	
	PARAMETER_ERROR("400","parameter error"),
	NO_ACCEPTABLE_REPRESENTATION("400","data error"),
	METHOD_NOT_ALLOWED("405","method not allowed"),
	
	SERVER_ERROR("500","server error"),
	DATA_NOT_FOUND("500","data not found");
	
	
	private String error;
	private String errorMessage;
	
	ErrorCode(String error,String errorMessage){
		this.error = error;
		this.errorMessage = errorMessage;
	}
}
