package com.cafe.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.ItemDTO;
import com.cafe.dto.UsersDTO;
import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;
import com.cafe.entity.UsersVO;
import com.cafe.service.UsersService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Tag(name = "유저 API", description = "로그인, 회원가입, 유저정보 API")
@RequestMapping("/api")
@RestController
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@GetMapping("/signUp/idCheck")
	public ErrorResponse duplicateCheck(@RequestParam String id) {
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
		
		boolean isSuccess = usersService.countById(id)==1?true:false;
		
		if(!isSuccess) {
			response = ErrorResponse.of(ErrorCode.OK, "ok");
		}
		
		return response;
	}
	
	@PostMapping("/signUp")
	public ErrorResponse signUp(@RequestBody UsersDTO usersDTO, HttpServletRequest request){
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
		
		System.out.println(usersDTO.toString() + " try signup...");
	
		HttpSession httpSession = request.getSession();
		
		boolean isSuccess = usersService.signUp(usersDTO.getId(),usersDTO.getPassword(),usersDTO.getName(),usersDTO.getEmail(),usersDTO.getPhone()) == 1?true:false;
		
		if(isSuccess) {
			httpSession.setAttribute("id", usersDTO.getId());
			httpSession.setAttribute("password", usersDTO.getPassword());
		
			response = ErrorResponse.of(ErrorCode.OK, "");
			
			System.out.println(usersDTO.getId() +  " signup successful!!");
		}else {
			System.out.println(usersDTO.getId() +  " signup failed");
		}
		
		return response;
	}
	
	@PostMapping("/login")
	public ErrorResponse login(HttpServletRequest request,@RequestBody UsersDTO usersDTO){				
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR,null);
		
		System.out.println("id : " + usersDTO.getId() + " , password : " + usersDTO.getPassword() + " try login...");

		HttpSession httpSession = request.getSession();
		
		Optional<UsersVO> user = usersService.findByIdAndPassword(usersDTO.getId(),usersDTO.getPassword()); 
		
		if(user.isPresent()) {
			httpSession.setAttribute("id", usersDTO.getId());
			httpSession.setAttribute("password", usersDTO.getPassword());

			response = ErrorResponse.of(ErrorCode.OK,UsersDTO.of(user.get()));
			System.out.println(usersDTO.toString() + " login successful!!");			
		}else {
			System.out.println(usersDTO.toString() + " login failed");	
		}
		
	    return response;	    
	}
	
	@GetMapping("/logout")
	public ErrorResponse logout(HttpServletRequest request) {		
		
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		
		response = ErrorResponse.of(ErrorCode.OK, "");
		
	    return response;
	}
	
	@GetMapping("/user")
	public ErrorResponse user(HttpServletRequest request) {
		ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
		
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("id");

		UsersVO usersVO = usersService.findById(id).orElseThrow(NoSuchElementException::new);
		
		System.out.println(usersVO.getId() + " user information loading..");
		
		response = ErrorResponse.of(ErrorCode.OK, UsersDTO.of(usersVO));
		
		return response;
	}
	
	@PatchMapping("/user/updateUserInfo")
	public ResponseEntity<ErrorResponse> updateUserInfoPhone(HttpServletRequest request, @RequestBody ItemDTO itemDTO) {
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(ErrorResponse.of(ErrorCode.SERVER_ERROR, ""),HttpStatus.OK);
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("id");
		String item_name = itemDTO.getName();
		String item_value = (String)itemDTO.getValue();
		
		System.out.println(id + " user information saving ...");
		System.out.println("item name : " + item_name);
		System.out.println("item value : " + item_value);
		
		usersService.updateUserInfo(id, item_name, item_value);
		
		response = new ResponseEntity<>(ErrorResponse.of(ErrorCode.NO_CONTENT, ""),HttpStatus.NO_CONTENT);
		
		System.out.println(id + " user information saving Successful!!!");
		
		return response;
	}
}
