package com.cafe.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.entity.EventProductVO;
import com.cafe.service.EventProductService;

import jakarta.servlet.http.Cookie;
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
	public List<EventProductVO> index(HttpServletRequest request, HttpServletResponse response) {
		
		httpSession = request.getSession();
		httpSession.setAttribute("name", "kiuk");
		httpSession.setMaxInactiveInterval(10);
		
		Cookie cookie = new Cookie("myCoookie","asdfasdf");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		// 30초간 저장
		cookie.setMaxAge(10);
		cookie.setSecure(true);
		response.addCookie(cookie);
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=1; i<6; i++) {
			list.add(String.valueOf(i));
		}
		List<EventProductVO> products = eventProductService.findAllById(list);
		
		return products;
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request) {
		
		httpSession = request.getSession();
		System.out.print(httpSession.getMaxInactiveInterval());
		
		String name = String.valueOf(httpSession.getAttribute("name"));
		if(name.equals("kiuk"))
			return "success";
		
		return null;
	}
}
