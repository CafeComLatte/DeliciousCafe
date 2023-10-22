package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name="product")
@AllArgsConstructor
public class ProductVO {

	@Id
	private String id;
	private String name;
	private long price;
	private String image;
	private String contents;
	private String sys_date;
	
	@Builder
	public ProductVO() {
		
	}
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", contents="
				+ contents + ", sys_date=" + sys_date + "]";
	}
	
}
