package com.cafe.dto;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.cafe.entity.ProductVO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPageDTO {
	private List<ProductDTO> elements;
	private long totalElements;
	private int currentPage;
	private int totalPages;
	
	public static ProductPageDTO of(Page<ProductVO> product) {
		return ProductPageDTO.builder()
				.elements(product.getContent().stream().map(entity->ProductDTO.of(entity)).collect(Collectors.toList()))
				.totalElements(product.getTotalElements())
				.totalPages(product.getTotalPages())
				.currentPage(product.getNumber()).build();
				
	}
	
	
}
