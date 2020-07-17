package com.example.messageservice.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDto {
	
	@NotNull
	@Length(min=3, max=10)
	private String id;
	@NotNull
	@Length(min=3, max=15)
	private String author;
	@NotNull
	@Length(min=10, max=300)
	private String message;
	

}
