package com.example.notesservice.exception;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.repo.NoteRepository;
import com.example.notesservice.service.NoteServiceImpl;
import com.example.utils.MasterData;
public class TestExceptions {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NoteServiceImpl noteServiceImpl;

	@Test
	public void testAddNote() throws Exception {
	    NotesDto notesdto = new NotesDto();
		notesdto.setAuthor("Praveen");
		when(noteServiceImpl.addNote(notesdto)).thenReturn(notesdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notesservice/add")
			.content(MasterData.toJson(notesdto))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int x = result.getResponse().getStatus();
		assertEquals(x,400);
	}
	
	@Test
	public void testDeleteNote() throws Exception {
	    NotesDto notesdto = new NotesDto();
		notesdto.setId("100061");
		when(noteServiceImpl.addNote(notesdto)).thenReturn(notesdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notesservice/delete")
			.content(MasterData.toJson(notesdto))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int x = result.getResponse().getStatus();
		assertEquals(x,400);
	}
	
}
