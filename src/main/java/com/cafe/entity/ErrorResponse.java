package com.cafe.entity;

import lombok.Getter;

@Getter
public class ErrorResponse {
	
	private String error;
	private String errorMessage;
	private Object data;
	
	public ErrorResponse(ErrorCode code, Object data) {
		this.error = code.getError();
		this.errorMessage = code.getErrorMessage();
		this.data = data;
	}
	
	public static ErrorResponse of(ErrorCode code,Object data) {
		return new ErrorResponse(code, data);
	}
}
