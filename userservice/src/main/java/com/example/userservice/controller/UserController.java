package com.example.userservice.controller;

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
import org.springframework.web.client.RestTemplate;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.Note;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import static com.example.userservice.utils.UserUtilities.converToUser;
import static com.example.userservice.utils.UserUtilities.convertToUserDto;
@RestController
@RequestMapping("/userservice")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List<UserDto> getAllUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto user){
		HttpStatus status = HttpStatus.CREATED;
		userService.register(user);
		return new ResponseEntity<>(user,status);
	}
	
	@GetMapping("/login")
	public boolean login(@RequestBody UserDto user) {
		return userService.login(user);
	}
	
	@GetMapping("/viewNotes")
	public List<Note> findNotesByAuthor(@PathVariable("author") String author){
		
		restTemplate.getForObject("http://localhost:8762/noteservice/author/"+author, Note.class);
		
		return null;
		
		
	}

	
}
