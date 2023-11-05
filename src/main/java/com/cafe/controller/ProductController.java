package com.cafe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.ProductPageDTO;
import com.cafe.entity.ErrorCode;
import com.cafe.entity.ErrorResponse;
import com.cafe.entity.ProductVO;
import com.cafe.service.ProductService;

@RequestMapping("api")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ProductPageDTO getProducts(@PageableDefault Pageable pageable) {
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		return ProductPageDTO.of(productService.findAll(pageable));
	}
	
	@GetMapping("/products/{id}")
	public ErrorResponse getProduct(@PathVariable(value = "id",required = true) String id){
		ErrorResponse response = ErrorResponse.of(ErrorCode.DATA_NOT_FOUND, null);
		Optional<ProductVO> product = productService.findById(id);
		if(product.isPresent()) {
			response = ErrorResponse.of(ErrorCode.OK, product);	
		}
		return response;
		
	}
}
