package com.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafe.entity.PurchaseVO;
import com.cafe.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public Page<PurchaseVO> findAll(Pageable pageable){
		return purchaseRepository.findAll(pageable);
	}
}
