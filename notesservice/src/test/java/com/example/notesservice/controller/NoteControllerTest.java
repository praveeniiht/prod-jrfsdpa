package com.example.notesservice.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.notesservice.dao.NotesDto;
import com.example.notesservice.service.NoteServiceImpl;
import com.example.utils.MasterData;
import static com.example.utils.TestUtils.businessTestFile;
import static com.example.utils.TestUtils.yakshaAssert;
import static com.example.utils.TestUtils.currentTest;

@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(NoteController.class)
class NoteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NoteServiceImpl noteService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindAll() throws Exception {
		List<NotesDto> list = new ArrayList<NotesDto>();
		NotesDto notesdto = MasterData.getNotesDto();
		list.add(notesdto);
		when(noteService.findAll()).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/noteservice/all")
				.content(MasterData.asJsonString(MasterData.getNotesDto())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
				businessTestFile);
	}

	@Test
	void testAddNote() throws Exception {
		Mockito.when(noteService.addNote(MasterData.getNotesDto())).thenReturn(MasterData.getNotes());	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/gift-card/addGiftCardOrder")
				.content(MasterData.asJsonString(MasterData.getNotesDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}

	@Test
	void testDeleteNote() throws Exception {
		Mockito.when(noteService.deleteNote(MasterData.getNotesDto())).thenReturn(MasterData.getNotesDto());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/noteService/delete")
				.content(MasterData.asJsonString(MasterData.getNotesDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.OK.value() ? "true" : "false"), 
		businessTestFile);
	}

	
	
	
	
}
