package com.cafe.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.ItemDTO;
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
	
	@PatchMapping("/user/updateUserSettingInfo")
	public ResponseEntity<ErrorResponse> updateUserSettingInfo(HttpServletRequest request, @RequestBody ItemDTO itemDTO){
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(ErrorResponse.of(ErrorCode.SERVER_ERROR, ""),HttpStatus.OK);
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("id");
		String item_name = itemDTO.getName();
		Boolean item_value = (Boolean) itemDTO.getValue();
		
		System.out.println(id + " user setting information saving ...");
		System.out.println("item name : " + item_name);
		System.out.println("item value : " + item_value);
		
		usersSettingService.updateUserSettingInfo(id, item_name, item_value);
		
		response = new ResponseEntity<>(ErrorResponse.of(ErrorCode.NO_CONTENT,""),HttpStatus.NO_CONTENT);
		
		System.out.println(id + " user setting information saving Successful!!!");
		
		return response;
	}
}
