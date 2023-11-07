package com.cafe.entity;

import com.cafe.utils.BooleanToYNConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity(name="users_setting")
@AllArgsConstructor
@NoArgsConstructor
public class UsersSettingVO {
	
	@Id
	private String id;
	
	@Convert(converter = BooleanToYNConverter.class)
	private boolean phone;
	
	@Convert(converter = BooleanToYNConverter.class)
	private boolean email;

	public void setPhone(boolean phone) {
		this.phone = phone;
	}
	
	public void setEmail(boolean email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UsersSettingVO [id=" + id + ", phone=" + phone + ", email=" + email + "]";
	} 
	
	
}
