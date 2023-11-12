package com.cafe.service;

import java.util.Optional;

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
	
	public Optional<ProductVO> findById(String id){
		return productRepository.findById(id);
	}

	public Page<ProductVO> findByNameContaining(String search_name,Pageable pageable) {
		return productRepository.findByNameContaining(search_name, pageable);
	}
}
