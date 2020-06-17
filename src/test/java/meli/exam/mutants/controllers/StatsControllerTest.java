package meli.exam.mutants.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import meli.exam.mutants.services.DnaAnalyzerService;
import meli.exam.mutants.services.dtos.Stats;

@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
public class StatsControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DnaAnalyzerService dnaAnalyzerService;

	@Test
	public void getStats() throws Exception {
		Stats stats = new Stats(1L, 1L);
		when(dnaAnalyzerService.getStats()).thenReturn(stats);

		mockMvc.perform(get("/stats/")).andExpect(status().isOk())
				.andExpect(content().json(asJsonString(stats)));

		verify(dnaAnalyzerService, times(1)).getStats();
		verifyNoMoreInteractions(dnaAnalyzerService);
	}

	@Test
	public void getNoStats() throws Exception {
		Stats stats = new Stats(0, 0);
		when(dnaAnalyzerService.getStats()).thenReturn(stats);
		mockMvc.perform(get("/stats/")).andExpect(status().isOk())
				.andExpect(content().json(asJsonString(stats)));

		verify(dnaAnalyzerService, times(1)).getStats();
		verifyNoMoreInteractions(dnaAnalyzerService);
	}

	private static String asJsonString(final Object obj) {
		try {
			return (new ObjectMapper()).writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
