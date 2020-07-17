package com.example.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection="Users")
@Data
@NoArgsConstructor
public class User {
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String username;
	@Column
	private String password;
}
