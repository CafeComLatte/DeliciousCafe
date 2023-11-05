package com.cafe.dto;

import com.cafe.entity.UsersSettingVO;
import com.cafe.utils.BooleanToYNConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Id;
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
public class UsersSettingDTO {

	private String id;
	private boolean phone;
	private boolean email;

	public static UsersSettingDTO of(UsersSettingVO userSetting) {
		return UsersSettingDTO.builder()
				.id(userSetting.getId())
				.phone(userSetting.isPhone())
				.email(userSetting.isEmail())
				.build();
	}
}
