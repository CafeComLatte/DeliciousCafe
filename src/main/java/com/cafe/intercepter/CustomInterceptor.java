package com.cafe.intercepter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class CustomInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("id");
		
		boolean sCheck = false;
		
		if(id != null) {
			sCheck = true;
		}
		
		System.out.println(request.getRequestURI());
		
		if((request.getRequestURI().startsWith("/site") || request.getRequestURI().startsWith("/api")) && !sCheck) {
			System.out.println("로그인 안된상태");
			response.sendRedirect("/login");
		}
		else {
			
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		
	}

	
}
