package com.softeer.caart.domain.recommendation.persona;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softeer.caart.domain.recommendation.persona.controller.PersonaController;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.service.PersonaService;
import com.softeer.caart.global.handler.GlobalExceptionHandler;
import com.softeer.caart.global.response.DataResponseDto;

@ExtendWith(MockitoExtension.class)
class PersonaControllerTest {

	@InjectMocks
	PersonaController personaController;

	@Mock
	PersonaService personaService;

	MockMvc mockMvc;
	Gson gson;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(personaController)
			.setControllerAdvice(new GlobalExceptionHandler())
			.build();
		gson = new Gson();
	}

	@Test
	@DisplayName("페르소나 전체 목록 조회에 성공한다")
	void getPersonas() throws Exception {
		// given
		final String url = "/personas";
		final List<PersonaResponse> personaResponses = new ArrayList<>();
		personaResponses.add(PersonaResponse.builder()
			.personaId(-1L)
			.profileImage("프로필 이미지")
			.coverLetter("대표 문구")
			.tags(List.of("태그1", "태그2")).build());

		doReturn(personaResponses).when(personaService).getPersonas();

		// when
		ResultActions resultActions = mockMvc.perform(
			MockMvcRequestBuilders.get(url)
		);

		// then
		resultActions.andExpect(status().isOk());

		Type responseType = new TypeToken<DataResponseDto<List<PersonaResponse>>>() {
		}.getType();
		DataResponseDto<List<PersonaResponse>> response = gson.fromJson(
			resultActions.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8),
			responseType);

		assertThat(response.getData()).hasSize(1);
		assertThat(response.getData().get(0).getCoverLetter()).isEqualTo("대표 문구");
	}
}
