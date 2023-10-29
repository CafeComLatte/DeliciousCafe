package com.cafe.dto;

import java.util.Collection;

import com.cafe.entity.ProductVO;
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
	private String product_id;
	private long price;
	private long count;
	private long total_price;
	private String payment_date;
	private String payment_time;
	private String user_id;
	private Collection<ProductVO> products;
	
	public static PurchaseDTO of(PurchaseVO payment) {
		return PurchaseDTO.builder()
			.product_id(payment.getProduct_id())
			.price(payment.getPrice())
			.count(payment.getCount())
			.total_price(payment.getTotal_price())
			.payment_date(payment.getPayment_date())
			.payment_time(payment.getPayment_time())
			.user_id(payment.getUser_id())
			.products(payment.getProduct())
			.build();
	}

	@Override
	public String toString() {
		return "PurchaseDTO [product_id=" + product_id + ", price=" + price + ", count=" + count + ", total_price="
				+ total_price + ", payment_date=" + payment_date + ", payment_time=" + payment_time + ", user_id="
				+ user_id + ", products=" + products + "]";
	}

	
	
	
}
