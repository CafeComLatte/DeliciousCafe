package com.cafe.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.entity.UserVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RequestMapping("api")
@Controller
public class UserController {

	private HttpSession httpSession;
	
	@PostMapping("/login")
	@ResponseBody
	public HashMap<String, Object> login(HttpServletRequest request,@RequestBody UserVO userVO) {
		
		httpSession = request.getSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
	    
		map.put("status", "400");
		

		httpSession.setAttribute("id", userVO.getId());
		httpSession.setAttribute("password", userVO.getPassword());
		
		map.put("status", "200");
		
	    return map;
	}
}
