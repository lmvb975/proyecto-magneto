package com.magneto.project;


import com.magneto.project.objetos.ObjetosAdn;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class MutantMagnetoTests {

	@Autowired
	private MockMvc mockMvc;

	private static final String URL_MUTANT = "/mutant";

	@Test
	public void mutanteValidoTest() throws Exception {
		mockMvc.perform(post(URL_MUTANT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(ObjetosAdn.ADN_MUTANTE))
				.andExpect(status().isOk());
	}


	@Test
	public void adnHumanoTest() throws Exception {
		mockMvc.perform(post(URL_MUTANT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(ObjetosAdn.ADN_HUMANO))
				.andExpect(status().isForbidden());
	}

	@Test
	public void nxmAdnTest() throws Exception {
		mockMvc.perform(post(URL_MUTANT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(ObjetosAdn.NXM_ADN))
				.andExpect(status().isForbidden());
	}

	@Test
	public void baseNitrogenadaInvalidaTest() throws Exception {
		mockMvc.perform(post(URL_MUTANT)
				.contentType(MediaType.APPLICATION_JSON)
				.content(ObjetosAdn.BASE_NITROGENADA_INVALIDA))
				.andExpect(status().isForbidden());
	}
}
