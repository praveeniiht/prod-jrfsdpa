package com.example.notesservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notesservice.dao.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.repo.NoteRepository;
import static com.example.notesservice.utils.NotesUtilities.convertToNote;
import static com.example.notesservice.utils.NotesUtilities.convertToNoteDto;
import static com.example.notesservice.utils.NotesUtilities.convertToNotesDtoList;
@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<NotesDto> findAll() {
		// TODO Auto-generated method stub
		List<Note> list =  noteRepository.findAll();
		return convertToNotesDtoList(list);
	}

	@Override
	public Optional<Note> findById(String id) {
		// TODO Auto-generated method stub
		return  noteRepository.findById(id);
		
	}

	@Override
	public Note addNote(NotesDto note) {
		// TODO Auto-generated method stub
		return noteRepository.save(convertToNote(note));
	}

	@Override
	public void deleteNote(NotesDto note) {
		// TODO Auto-generated method stub
		noteRepository.delete(convertToNote(note));

	}

	@Override
	public List<NotesDto> findAllByStatus(String status) {
		// TODO Auto-generated method stub
		List<Note> list = noteRepository.findAll();
		List<Note> notes = list.stream()
						 			.filter(n->n.getStatus().equals(status))
						 			.collect(Collectors.toList()); 
		return convertToNotesDtoList(notes);
	}

	@Override
	public List<NotesDto> findAllByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Note> list = noteRepository.findAll();
		List<Note> notes = list.stream()
							.filter(n->n.getAuthor().equals(author))
							.collect(Collectors.toList());
		return convertToNotesDtoList(notes);
	}

	@Override
	public List<NotesDto> findAllByTitle(String title) {
		// TODO Auto-generated method stub
		List<Note> list = noteRepository.findAll();
		List<Note> notes = list.stream()
							.filter(n->n.getTitle().equals(title))
							.collect(Collectors.toList());
		return convertToNotesDtoList(notes);
	}

}
