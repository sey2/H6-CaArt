package com.softeer.caart.domain.recommendation.persona;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;
import com.softeer.caart.domain.recommendation.persona.service.PersonaService;

class PersonaServiceTest extends ServiceTest {

	@InjectMocks
	PersonaService personaService;

	@Mock
	PersonaRepository personaRepository;

	@Test
	@DisplayName("모든 페르소나 데이터 목록을 가져온다")
	void getPersonas() {
		// given
		doReturn(List.of(persona)).when(personaRepository).findAll();

		// when
		List<PersonaResponse> personas = personaService.getPersonas();

		// then
		assertThat(personas).hasSize(1);
		assertThat(personas.get(0).getTags()).contains("태그1", "태그2");
	}

	@Test
	@DisplayName("아이디로 특정 페르소나 데이터를 가져온다")
	void getPersona() {
		// given
		Long personaId = 1L;
		doReturn(Optional.of(persona)).when(personaRepository).findById(personaId);

		// when
		PersonaDetailsResponse personaDetailsResponse = personaService.getPersona(personaId);

		// then
		assertThat(personaDetailsResponse).isNotNull();
	}
}
