package com.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.entity.UsersVO;
import com.cafe.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	public int signUp(String id, String password, String name, String email, String phone) {
		
		return usersRepository.signUp(id, password, name, email, phone);		
	}
	
	
}
