package com.example.userservice.service;

import java.util.List;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.Note;
import com.example.userservice.model.User;

public interface UserService {
	public List<UserDto> findAll();
	public UserDto register(UserDto user);
	public boolean login(UserDto user);
	
}
