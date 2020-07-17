package com.example.messageservice.service;

import java.util.List;

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;
import com.example.messageservice.model.Note;

public interface MessageService {
	public List<MessageDto> findAll();
	public MessageDto addMessage(MessageDto message);
	public List<MessageDto> getMessageByAuthor(String author);
}
