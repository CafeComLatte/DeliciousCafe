package com.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.PurchasePageDTO;
import com.cafe.entity.PurchaseVO;
import com.cafe.service.PurchaseService;

@RequestMapping("api")
@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;
	
	@PostMapping("/payments")
	public PurchasePageDTO getPayments(@PageableDefault Pageable pageable) {
		return PurchasePageDTO.of(purchaseService.findAll(pageable)); 
	}
}
