package com.example.messageservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.messageservice.model.Message;

public interface MessageRepository extends MongoRepository<Message, Long> {

}
