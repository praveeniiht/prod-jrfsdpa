package com.example.userservice.utils;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

public class UserUtilities {
	
	public static  UserDto convertToUserDto(User user) {
		UserDto usr = new UserDto();
		usr.setId(user.getId());
		usr.setUsername(user.getUsername());
		usr.setPassword(user.getPassword());
		return usr;
	}
	
	public static User converToUser(UserDto user) {
		User usr = new User();
		usr.setId(user.getId());
		usr.setUsername(user.getUsername());
		usr.setPassword(user.getPassword());
		return usr;
	}

}
