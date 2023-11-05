package com.cafe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "users")
@NamedStoredProcedureQuery(
        name = UsersVO.NamedQuery_SIGNUP,
        procedureName = "SIGNUP",
        resultClasses = UsersVO.class,
        parameters = {
                @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "password", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "email", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "phone", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RESULT", type = Integer.class, mode = ParameterMode.OUT),
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVO {
	
	public static final String NamedQuery_SIGNUP = "SIGNUP";
	
	@Id
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "user information [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
	
}
