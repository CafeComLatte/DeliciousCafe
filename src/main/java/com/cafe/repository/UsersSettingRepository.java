package com.cafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.UsersSettingVO;


@Repository
public interface UsersSettingRepository extends JpaRepository<UsersSettingVO, String>{
	
	Optional<UsersSettingVO> findById(String id); 
	
}
