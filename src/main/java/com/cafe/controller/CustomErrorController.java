package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public CustomErrorController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping("/error")
	public ResponseEntity<ErrorResponse> handleError(HttpServletRequest request) {
		
		System.out.println("URI : " + request.getRequestURI() + ", Error : " + getErrorFromRequest1(request));
		return new ResponseEntity<>(ErrorResponse.of(ErrorCode.SERVER_ERROR, ""), HttpStatus.OK);
	}

	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions includeStackTrace) {
		return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
	}

	public  Throwable getError(WebRequest webRequest) {
		return this.errorAttributes.getError(webRequest);
	}

	private String getErrorFromRequest1(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Throwable errorRequest = getError(webRequest);

        return errorRequest.getMessage();      
    }
	
	
	private HashMap<Integer, String> getErrorFromRequest(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        List<ErrorAttributeOptions.Include> list = new ArrayList<ErrorAttributeOptions.Include>();
        list.add(Include.BINDING_ERRORS);
        list.add(Include.EXCEPTION);
        list.add(Include.MESSAGE);
        list.add(Include.STACK_TRACE);
        Map<String, Object> errorRequest = getErrorAttributes(webRequest, ErrorAttributeOptions.of(Include.BINDING_ERRORS));

        int errorStatus = (int) errorRequest.get("status");
        String errorMessage =  errorRequest.get("error").toString();

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(errorStatus, errorMessage);
        
        return map;
    }
}
