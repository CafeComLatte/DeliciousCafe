package com.cafe.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.entity.UsersVO;
import com.cafe.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RequestMapping("api")
@Controller
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@PostMapping("/signUp")
	@ResponseBody
	public HashMap<String, Object> signUp(@RequestBody UsersVO userVO, HttpServletRequest request){
		System.out.println("Try Sign up : " + userVO.toString());
	
		HttpSession httpSession = request.getSession();
		
		boolean isSuccess = false;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		isSuccess = usersService.signUp(userVO.getId(),userVO.getPassword(),userVO.getName(),userVO.getEmail(),userVO.getPhone()) == 1?true:false;
		
		if(isSuccess) {
			httpSession.setAttribute("id", userVO.getId());
		}
		
		map.put("result", isSuccess);
		return map;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public HashMap<String, Object> login(HttpServletRequest request,@RequestBody UsersVO userVO) {
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		
	    return map;
	}
}
