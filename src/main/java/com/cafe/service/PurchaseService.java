package com.cafe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafe.entity.PurchaseVO;
import com.cafe.repository.PurchaseRepository;
import com.cafe.utils.DateUtils;

import jakarta.servlet.http.HttpSession;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public Page<PurchaseVO> findAll(Pageable pageable){
		return purchaseRepository.findAll(pageable);
	}
	
	public PurchaseVO save(PurchaseVO purchase) {
		purchase.setPayment_date(DateUtils.getNowDate());
		purchase.setPayment_time(DateUtils.getNowTime());
		
		
		return purchaseRepository.save(purchase);
	}
}
