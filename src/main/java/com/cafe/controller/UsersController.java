package com.cafe.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public HashMap<String, Object> login(HttpServletRequest request,@RequestBody UsersVO usersVO) {				
		System.out.println("Try login : " + usersVO.toString());
		
		HttpSession httpSession = request.getSession();
		
		boolean isSuccess = false;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		isSuccess = usersService.countByIdAndPassword(usersVO.getId(),usersVO.getPassword()) == 1?true:false; 
		
		map.put("result", isSuccess);
		
	    return map;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public HashMap<String, Object> logout(HttpServletRequest request) {
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		map.put("result", "true");
		
	    return map;
	}
}
