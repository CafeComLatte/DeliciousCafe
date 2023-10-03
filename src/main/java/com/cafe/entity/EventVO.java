package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="event")
@Getter
@NoArgsConstructor
public class EventVO {
	
	@Id
	private String id;
	private String image;

	@Builder
	public EventVO(String id, String image) {
		this.id = id;
		this.image = image;
	}
}
