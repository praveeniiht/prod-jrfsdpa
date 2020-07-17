package com.example.notesservice.service;

import java.util.List;
import java.util.Optional;

import com.example.notesservice.dao.NotesDto;
import com.example.notesservice.model.Note;

public interface NoteService {
	
	public List<NotesDto> findAll();
	public Optional<Note> findById(String id);
	public Note addNote(NotesDto note);
	public NotesDto deleteNote(NotesDto note);
	public List<NotesDto> findAllByStatus(String status);
	public List<NotesDto> findAllByAuthor(String author);
	public List<NotesDto> findAllByTitle(String title);

}
