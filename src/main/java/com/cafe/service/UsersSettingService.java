package com.cafe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.entity.UsersSettingVO;
import com.cafe.repository.UsersSettingRepository;

@Service
public class UsersSettingService {

	@Autowired
	UsersSettingRepository usersSettingRepository;
	
	public Optional<UsersSettingVO> findById(String id){
		return usersSettingRepository.findById(id);
	}
}
