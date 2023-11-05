package com.cafe.dto;

import java.util.HashMap;

import com.cafe.entity.UsersVO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	public static HashMap<String,Object> of(UsersVO user) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("id", user.getPassword());
		hashMap.put("name", user.getName());
		hashMap.put("email", user.getEmail());
		hashMap.put("phone", user.getPhone());
		return hashMap;
	}
	
	public static HashMap<String,Object> ofLogin(UsersVO user) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("id", user.getPassword());
		hashMap.put("password", user.getPassword());
		return hashMap;
	}

	public static HashMap<String,Object> ofSignup(UsersVO user) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("id", user.getPassword());
		hashMap.put("password", user.getPassword());
		hashMap.put("name", user.getName());
		hashMap.put("email", user.getEmail());
		hashMap.put("phone", user.getPhone());
		return hashMap;
	}

	@Override
	public String toString() {
		return "UsersDTO [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
	
}
