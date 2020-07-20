package com.example.notesservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;
import static com.example.notesservice.utils.NotesUtilities.convertToNoteDto;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public ResponseEntity<List<NotesDto>> findAll(){
		 HttpStatus httpStatus = HttpStatus.OK; 
		 List<NotesDto> dtolist= noteService.findAll(); 
		 return new ResponseEntity<>(dtolist,httpStatus);
	}
	
	@PostMapping("/add")
	public ResponseEntity<NotesDto> addNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.CREATED;
    	NotesDto saved = noteService.addNote(note);
        return new ResponseEntity<>(saved, status);
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<NotesDto> deleteNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.OK;
		NotesDto notedto = noteService.deleteNote(note);
		return new ResponseEntity<>(notedto,status);
	}
	
	@GetMapping("/note/{id}")
	public ResponseEntity<NotesDto> findById(@PathVariable("id") String id){
		HttpStatus status = HttpStatus.OK;
		NotesDto notesdto=   noteService.findById(id);
		return new ResponseEntity<>(notesdto,status);
	}
	
	@GetMapping("/{status}")
	public ResponseEntity<List<NotesDto>> findAllByStatus(@PathVariable("status") String status){
		HttpStatus httpStatus = HttpStatus.OK;
		List<NotesDto> dtolist = noteService.findAllByStatus(status);
		return new ResponseEntity<>(dtolist,httpStatus);
	}
	
}
