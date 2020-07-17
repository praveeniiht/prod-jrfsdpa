package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.Note;
import com.example.userservice.model.User;
import com.example.userservice.repo.UserRepository;
import static com.example.userservice.utils.UserUtilities.converToUser;
import static com.example.userservice.utils.UserUtilities.convertToUserDto;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
		List<UserDto> dtolist = new ArrayList<UserDto>();
		for(User u: list) {
			dtolist.add(convertToUserDto(u));
		}
		return dtolist;
	}

	@Override
	public UserDto register(UserDto user) {
		// TODO Auto-generated method stub
		userRepository.save(converToUser(user));
		return user;
	}

	@Override
	public boolean login(UserDto user) {
		// TODO Auto-generated method stub
		boolean found=false;
		List<User> users = userRepository.findAll();
		for(User usr:users) {
			if(usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword())){
				found=true;
				break;
			}
		}
		return found;
	}

	
}
