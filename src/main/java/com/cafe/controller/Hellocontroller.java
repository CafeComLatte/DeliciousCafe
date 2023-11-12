package com.cafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class Hellocontroller {
	
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		return "test";
	}
}
