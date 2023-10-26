package com.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.dto.ProductPageDTO;
import com.cafe.service.ProductService;

@RequestMapping("api")
@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	@ResponseBody
	public ProductPageDTO getProducts(@PageableDefault Pageable pageable) {
		System.out.println(pageable.getPageNumber());
		return ProductPageDTO.of(productService.findAll(pageable));
	}
}
