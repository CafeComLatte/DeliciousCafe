package com.cafe.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.dto.ProductPageDTO;
import com.cafe.entity.ProductVO;
import com.cafe.entity.ResponseResult;
import com.cafe.entity.ResponseVO;
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
	public ResponseVO getProduct(@PathVariable(value = "id",required = true) String id){
		ResponseVO response = new ResponseVO();
		response.setResult(new ResponseResult("error", "dataerror"));
		
		Optional<ProductVO> product = productService.findById(id);
		if(product.isPresent()) {
			response.setData(product.get());
			response.setResult(new ResponseResult("", "errorNone"));
			
		}else {
			
		}
		
		
		return response;
		
	}
}
