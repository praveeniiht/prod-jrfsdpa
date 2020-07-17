package com.example.notesservice.exceptions;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
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
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;
import com.example.notesservice.service.NoteServiceImpl;
import com.example.utils.MasterData;
import static com.example.utils.TestUtils.yakshaAssert;
import static com.example.utils.TestUtils.exceptionTestFile;
import static com.example.utils.TestUtils.currentTest;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(NotesDto.class)

public class TestExceptions {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NoteService noteService;
		
	@Test
	public void testAddNotesDtoException() throws Exception {
		
		 NotesDto badData = MasterData.getNotesDto();
		badData.setId("123");
		badData.setAuthor("ab");
		Mockito.when(noteService.addNote(badData)).thenReturn(MasterData.getNotes());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notesservice/add")
				.content(MasterData.asJsonString(MasterData.getNotesDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), 
		exceptionTestFile);
	}
	
	@Test
	public  void testDeleteGiftCardException() throws Exception{
		NotesDto badData = MasterData.getNotesDto();
		badData.setId("123");
		badData.setAuthor("ab");
		Note note = MasterData.getNotes();
		when(noteService.addNote(badData)).thenReturn(note);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/notesservice/delete")
				.content(MasterData.asJsonString(MasterData.getNotesDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), 
		exceptionTestFile);
	}

	
}
