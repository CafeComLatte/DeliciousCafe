package com.cafe.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.entity.EventVO;
import com.cafe.service.EventService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api")
public class EventController {

		@Autowired
		EventService eventService;
	
		@GetMapping("/getEvent")
		@ResponseBody
		public HashMap<String, Object> getEvent(HttpServletRequest request, HttpServletResponse response){
			HashMap<String, Object> result = new HashMap<String, Object>();
			
			result.put("result", "fail");
			
			Optional<EventVO> event = eventService.findById("1");
			if(event.isPresent()) {
				result.put("data", event.get());
				result.put("result", "okay");
			}
			
			return result;
		}
}
