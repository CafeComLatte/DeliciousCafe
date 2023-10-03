package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.entity.EventProductVO;
import com.cafe.service.EventProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("api")
public class Hellocontroller {

	@Autowired
	EventProductService eventProductService;
	
	private HttpSession httpSession;
	
	@GetMapping("/hello")
	@ResponseBody
	public Object index(HttpServletRequest request, HttpServletResponse response) {
		
		httpSession = request.getSession();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=1; i<6; i++) {
			list.add(String.valueOf(i));
		}
		List<EventProductVO> products = eventProductService.findAllById(list);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("data", products);
		map.put("result", "200");
		
		return map;
	}
	
	
}
