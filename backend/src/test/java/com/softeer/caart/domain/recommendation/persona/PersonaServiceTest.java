package com.softeer.caart.domain.recommendation.persona;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.entity.Profile;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;
import com.softeer.caart.domain.recommendation.persona.service.PersonaService;
import com.softeer.caart.domain.tag.entity.Tag;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

	@InjectMocks
	PersonaService personaService;

	@Mock
	PersonaRepository personaRepository;

	@Test
	@DisplayName("모든 페르소나 데이터 목록을 가져온다")
	void getPersonas() {
		// given
		Persona persona = Persona.builder()
			.id(1L)
			.profile(Profile.builder().image("프로필 이미지").build())
			.firstTag(Tag.builder().name("태그1").build())
			.secondTag(Tag.builder().name("태그2").build())
			.build();
		doReturn(List.of(persona)).when(personaRepository).findAll();

		// when
		List<PersonaResponse> personas = personaService.getPersonas();

		// then
		assertThat(personas).hasSize(1);
		assertThat(personas.get(0).getTags()).contains("태그1", "태그2");
	}
}
