package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name="event_product")
public class EventProductVO {
	
	@Id
	private String id;
	private String name;
	private long price;
	private String image;
	private String contents;
	private String sys_date;

	@Builder
	public EventProductVO(String id, String name, long price, String image, String contents, String sys_date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.contents = contents;
		this.sys_date = sys_date;
	}
}
