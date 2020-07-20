package com.example.notesservice.functional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.notesservice.NotesserviceApplication;
import com.example.notesservice.controller.NoteController;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.service.NoteService;
import com.example.notesservice.service.NoteServiceImpl;
import static com.example.utils.MasterData.toJson;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(NoteController.class)
@AutoConfigureMockMvc 
@SpringBootTest(classes = NotesserviceApplication.class)
@AutoConfigureTestDatabase
class NoteControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private NoteService noteService;
	
	@Test
	void testFindAll() throws Exception {
		NotesDto dto = new NotesDto();
		dto.setAuthor("Pranav");
		mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(toJson(dto)));
		List<NotesDto> found =  noteService.findAll();
        assertThat(found).extracting(NotesDto::getAuthor).containsOnly("Pranav");
	}

	@Test
	void testAddNote() {
		
	}

	@Test
	void testDeleteNote() {
		
	}

	@Test
	void testFindById() {
		
	}

	@Test
	void testFindAllByStatus() {
		
	}

}
