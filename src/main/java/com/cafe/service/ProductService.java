package com.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafe.entity.ProductVO;
import com.cafe.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Page<ProductVO> findAll(Pageable pageable){
		return productRepository.findAll(pageable);
	}
}
