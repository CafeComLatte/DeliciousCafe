package com.cafe.exceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cafe.entity.ResponseResult;
import com.cafe.entity.ResponseVO;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseVO noData() {
		ResponseVO response = new ResponseVO();
		response.setResult(new ResponseResult("error", "nodata"));
		return response;
	}
}
