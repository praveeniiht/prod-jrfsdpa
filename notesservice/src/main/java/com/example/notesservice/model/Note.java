package com.example.notesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "Notes")
@Data
@NoArgsConstructor
public class Note {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String description;
	@Column
	private String status;

}
