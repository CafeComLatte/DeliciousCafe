package com.cafe.entity;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="purchase")
@AllArgsConstructor
public class PurchaseVO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String product_id;
	private long price;
	private long count;
	private long total_price;
	private String payment_date;
	private String payment_time;
	private String user_id;
	
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "product_id")
	private Collection<ProductVO> product;
	
	public PurchaseVO() {
		
	}

	@Override
	public String toString() {
		return "PurchaseVO [id=" + id + ", product_id=" + product_id + ", price=" + price + ", count=" + count
				+ ", total_price=" + total_price + ", payment_date=" + payment_date + ", payment_time=" + payment_time
				+ ", user_id=" + user_id + ", product=" + product + "]";
	}

	

	
	
	
	
	
	
}
