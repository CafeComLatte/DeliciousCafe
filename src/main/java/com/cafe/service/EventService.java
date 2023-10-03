package com.cafe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.entity.EventVO;
import com.cafe.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public Optional<EventVO> findById(String id){
		return eventRepository.findById(id);
	}
}
