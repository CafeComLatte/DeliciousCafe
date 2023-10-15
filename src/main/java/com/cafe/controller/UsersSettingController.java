package com.cafe.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.entity.UsersSettingVO;
import com.cafe.service.UsersSettingService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("api")
@Controller
public class UsersSettingController {
	
	@Autowired
	UsersSettingService usersSettingService;
	
	@GetMapping("/userSetting")
	@ResponseBody
	public HashMap<String, Object> userSetting(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		boolean isSuccess = false;
		
		HttpSession httpSession = request.getSession();
		
		String id = (String)httpSession.getAttribute("id");
		
		Optional<UsersSettingVO> usersSettingVO = usersSettingService.findById(id);
		
		if(usersSettingVO.isPresent()) {
			isSuccess = true;
			map.put("data", usersSettingVO.get());
		}
		
		map.put("result",isSuccess);
		
		return map;
	}
}
