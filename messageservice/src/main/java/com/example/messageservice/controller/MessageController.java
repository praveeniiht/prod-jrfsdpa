package com.example.messageservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;
import com.example.messageservice.model.Note;
import com.example.messageservice.service.MessageService;

@RestController
@RequestMapping("/messageservice")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/all")
	public List<MessageDto> findAll(){
		return messageService.findAll();
	}
	
	@PostMapping("/add")
	public MessageDto addMessage(@RequestBody MessageDto message) {
		return messageService.addMessage(message);
	}
	
	@GetMapping("/show/{author}")
	public List<MessageDto> getMessagesByAuthor(@PathVariable("author") String author){
		return messageService.getMessageByAuthor(author);
	}
	
}
