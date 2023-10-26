package com.cafe.dto;

import com.cafe.entity.PurchaseVO;

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
public class PurchaseDTO {
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
	
	public static PurchaseDTO of(PurchaseVO payment) {
		return PurchaseDTO.builder()
			.id(payment.getId())
			.product_name(payment.getProduct_name())
			.contents(payment.getContents())
			.image(payment.getImage())
			.price(payment.getPrice())
			.count(payment.getCount())
			.total_price(payment.getTotal_price())
			.payment_date(payment.getPayment_date())
			.payment_time(payment.getPayment_time())
			.sys_date(payment.getSys_date()).build();
	}
}
