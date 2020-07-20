package com.example.notesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages="com.example.notesservice")
@EnableMongoRepositories(basePackages ="com.example.notesservice.repo")
@EntityScan("com.example.notesservice.model")
public class NotesserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesserviceApplication.class, args);
	}
}
