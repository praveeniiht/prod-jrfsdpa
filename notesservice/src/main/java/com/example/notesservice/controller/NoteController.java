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

import com.example.notesservice.dao.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;
import static com.example.notesservice.utils.NotesUtilities.convertToNoteDto;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/all")
	public List<NotesDto> findAll(){
		return noteService.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<NotesDto> addNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.CREATED;
    	 Note saved = noteService.addNote(note);
        return new ResponseEntity<>(convertToNoteDto(saved), status);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<NotesDto> deleteNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.OK;
		noteService.deleteNote(note);
		return new ResponseEntity<>(note,status);
	}
	
	@GetMapping("/note/{id}")
	public Optional<Note> findById(@PathVariable("id") String id){
			return  noteService.findById(id);
	}
	
	@GetMapping("/{status}")
	public List<NotesDto> findAllByStatus(@PathVariable("status") String status){
		return noteService.findAllByStatus(status);
	}
	
	@GetMapping("/author/{author}")
	public List<NotesDto> findAllByAuthor(@PathVariable("author") String author){
		return noteService.findAllByAuthor(author);
	}
	
	@GetMapping("note/title/{title}")
	public List<NotesDto> findAllByTitle(@PathVariable("title") String title){
		return noteService.findAllByTitle(title);
	}

	
}
