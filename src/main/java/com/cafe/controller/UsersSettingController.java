package com.cafe.controller;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.UsersSettingDTO;
import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;
import com.cafe.entity.UsersSettingVO;
import com.cafe.service.UsersSettingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("api")
@RestController
public class UsersSettingController {
	
	@Autowired
	UsersSettingService usersSettingService;
	
	@GetMapping("/userSetting")
	public ErrorResponse userSetting(HttpServletRequest request){
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
		
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("id");
		
		UsersSettingVO userSetting = usersSettingService.findById(id).orElseThrow(NoSuchElementException::new);
		response = ErrorResponse.of(ErrorCode.OK, UsersSettingDTO.of(userSetting));
		
		System.out.println(id + " user information setting loading..");
		
		return response;
	}
}
