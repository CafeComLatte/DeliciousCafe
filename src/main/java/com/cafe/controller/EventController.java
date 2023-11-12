package com.cafe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;
import com.cafe.entity.EventProductVO;
import com.cafe.entity.EventVO;
import com.cafe.service.EventProductService;
import com.cafe.service.EventService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class EventController {

		@Autowired
		EventService eventService;
	
		@Autowired
		EventProductService eventProductService;
		
		
		@GetMapping("/getEvent")
		public ErrorResponse getEvent(HttpServletRequest request){
			ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
			
			Optional<EventVO> event = eventService.findById("1");
			if(event.isPresent()) {
				response = ErrorResponse.of(ErrorCode.OK, event.get());
			}else {
				response = ErrorResponse.of(ErrorCode.OK, "");
			}
			
			return response;
		}
		
		@GetMapping("/getEventProduct")
		public ErrorResponse getEventProduct(HttpServletRequest request) {
			ErrorResponse response = ErrorResponse.of(ErrorCode.SERVER_ERROR, "");
			
			List<EventProductVO> products = eventProductService.findAll();
			if(products.size()>0) {
				response = ErrorResponse.of(ErrorCode.OK, products);
			}else {
				response = ErrorResponse.of(ErrorCode.OK, "");
			}
			return response;
		}
}
