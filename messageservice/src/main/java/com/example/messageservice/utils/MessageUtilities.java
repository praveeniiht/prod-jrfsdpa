package com.example.messageservice.utils;

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;

public class MessageUtilities {
		public static MessageDto convertToMessageDto(Message msg) {
		MessageDto msgdto = new MessageDto();
		msgdto.setId(msg.getId());
		msgdto.setAuthor(msg.getAuthor());
		msgdto.setMessage(msg.getMessage());
		return msgdto;
	}
	public static Message convertToMessage(MessageDto msgdto) {
		Message msg = new Message();
		msg.setId(msgdto.getId());
		msg.setAuthor(msgdto.getAuthor());
		msg.setMessage(msgdto.getMessage());
		return msg;
	}

}
