package com.example.messageservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;
import com.example.messageservice.model.Note;
import com.example.messageservice.repo.MessageRepository;
import static com.example.messageservice.utils.MessageUtilities.convertToMessage;
import static com.example.messageservice.utils.MessageUtilities.convertToMessageDto;
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<MessageDto> findAll() {
		// TODO Auto-generated method stub
		List<Message> list=  messageRepository.findAll();
		List<MessageDto> msgdto = new ArrayList<MessageDto>();
		for(Message msg: list) {
			msgdto.add(convertToMessageDto(msg));
		}
		return msgdto;
	}

	@Override
	public MessageDto addMessage(MessageDto message) {
		// TODO Auto-generated method stub
		messageRepository.save(convertToMessage(message));
		return message;
	}

	@Override
	public List<MessageDto> getMessageByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Message> list = messageRepository.findAll();
		List<Message> msgs = list.stream()
						 			.filter(n->n.getAuthor().equals(author))
						 			.collect(Collectors.toList()); 
		List<MessageDto> dtolist = new ArrayList<MessageDto>();
		for(Message m: msgs) {
			dtolist.add(convertToMessageDto(m));
		}
		return dtolist;
	}
	
	
}
