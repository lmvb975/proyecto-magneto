package com.magneto.project;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class StatsMagnetoTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String URL_STATS = "/stats";

	@Test
	public void statsAdnTest() throws Exception {
		mockMvc.perform(get(URL_STATS)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect(jsonPath("count_mutant_dna", is(8)))
//				.andExpect(jsonPath("count_human_dna", is(63)))
//				.andExpect(jsonPath("ratio", is(0.12698412698412698)));
	}
}
