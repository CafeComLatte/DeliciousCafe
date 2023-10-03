package com.cafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.EventVO;
import java.util.List;



@Repository
public interface EventRepository extends JpaRepository<EventVO, String>{
	public Optional<EventVO> findById(String id);
}	
