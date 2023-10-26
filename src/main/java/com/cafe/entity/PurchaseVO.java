package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name="purchase")
@AllArgsConstructor
public class PurchaseVO {

	@Id
	private String id;
	private String product_name;
	private String contents;
	private String image;
	private long price;
	private long count;
	private long total_price;
	private String payment_date;
	private String payment_time;
	private String sys_date;
	
	@Builder
	public PurchaseVO() {
		
	}

	@Override
	public String toString() {
		return "PurchaseVO [id=" + id + ", product_name=" + product_name + ", contents=" + contents + ", image=" + image
				+ ", price=" + price + ", count=" + count + ", total_price=" + total_price + ", payment_date="
				+ payment_date + ", payment_time=" + payment_time + ", sys_date=" + sys_date + "]";
	}
	
	
}
