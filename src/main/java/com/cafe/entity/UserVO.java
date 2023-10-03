package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "user")
@AllArgsConstructor
public class UserVO {
	
	@Id
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;

	@Builder
	public UserVO() {
		
	}
}
