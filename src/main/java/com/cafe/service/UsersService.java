package com.cafe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.dto.ItemDTO;
import com.cafe.entity.UsersVO;
import com.cafe.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;

	public int signUp(String id, String password, String name, String email, String phone) {
		
		return usersRepository.signUp(id, password, name, email, phone);		
	}
	
	public int countById(String id) {
		return usersRepository.countById(id);
	}
	
	public int countByIdAndPassword(String id, String password) {
		return usersRepository.countByIdAndPassword(id, password);
	}
	
	public Optional<UsersVO> findByIdAndPassword(String id, String password) {
		return usersRepository.findByIdAndPassword(id, password);
	}
	
	public Optional<UsersVO> findById(String id){
		return usersRepository.findById(id);
	}

	public void updateUserInfo(String id,String item_name, String item_value) {
		
		usersRepository.findById(id).ifPresent(user->{
			if("name".equals(item_name))user.setName(item_value);
			if("phone".equals(item_name))user.setPhone(item_value);
			if("email".equals(item_name))user.setEmail(item_value);
			usersRepository.save(user);
		});
	}
	
}
