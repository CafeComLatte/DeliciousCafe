package com.cafe.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.PurchasePageDTO;
import com.cafe.entity.PurchaseVO;
import com.cafe.entity.ResponseResult;
import com.cafe.entity.ResponseVO;
import com.cafe.service.PurchaseService;
import com.cafe.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequestMapping("api")
@RestController
@RequiredArgsConstructor
public class PurchaseController {

	private HttpSession httpSession;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	@GetMapping("/payments")
	public PurchasePageDTO getPayments(@PageableDefault Pageable pageable) {
		PurchasePageDTO page_data = PurchasePageDTO.of(purchaseService.findAll(pageable));
		System.out.println(page_data.toString());
		return page_data;
	}
	
	@PostMapping("/payProduct")
	public ResponseVO payProduct(HttpServletRequest request, @RequestBody PurchaseVO purchase) {
		System.out.println(purchase.toString());
		ResponseVO response = new ResponseVO();
		response.setResult(new ResponseResult("error", "dataerror"));
		boolean loginSuccess = false;
		
		httpSession = request.getSession();
		
		String id = (String)httpSession.getAttribute("id");
		String password = (String)httpSession.getAttribute("password");
		
		System.out.println("id : " + id + " ,  password : " + password);
		
		loginSuccess = usersService.countByIdAndPassword(id, password)==1?true:false;
		
		if(loginSuccess) {
			purchase.setUser_id(id);
			PurchaseVO savedPurchase = purchaseService.save(purchase);
			
			if(savedPurchase != null) {
				System.out.println("결제 완료");
				response.setResult(new ResponseResult("", "errorNone"));
				response.setData(savedPurchase);
			}
		}else {
			throw new NoSuchElementException();
		}
		
		return response;
	}
	
}
