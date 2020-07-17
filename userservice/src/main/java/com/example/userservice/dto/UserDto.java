package com.example.userservice.dto;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDto {
	@NotNull
	private String id;
	@NotNull
	@Length(min=5,max=15)
	private String username;
	@NotNull
	@Length(min=5, max=15)
	private String password;
	
}
