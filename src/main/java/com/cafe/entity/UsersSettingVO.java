package com.cafe.entity;

import com.cafe.utils.BooleanToYNConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name="users_setting")
@AllArgsConstructor
public class UsersSettingVO {
	
	@Id
	private String id;
	
	@Convert(converter = BooleanToYNConverter.class)
	private boolean phone;
	
	@Convert(converter = BooleanToYNConverter.class)
	private boolean email;

	@Builder
	public UsersSettingVO() {
		
	}
	
	@Override
	public String toString() {
		return "UsersSettingVO [id=" + id + ", phone=" + phone + ", email=" + email + "]";
	} 
	
	
}
