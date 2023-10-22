package com.cafe.dto;

import com.cafe.entity.ProductVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private String id;
	private String name;
	private long price;
	private String image;
	private String contents;
	private String sys_date;
	
	public static ProductDTO of(ProductVO product) {
		return ProductDTO.builder()
				.id(product.getId())
				.name(product.getName())
				.contents(product.getContents())
				.price(product.getPrice())
				.image(product.getImage())
				.sys_date(product.getSys_date()).build();
	}
}
