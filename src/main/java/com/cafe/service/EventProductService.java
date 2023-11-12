package com.cafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.entity.EventProductVO;
import com.cafe.repository.EventProductRepository;

@Service
public class EventProductService {

	@Autowired
	private EventProductRepository eventProductRepository;
	
	public List<EventProductVO> findAll() {
		return eventProductRepository.findAll();
	}
	
}
