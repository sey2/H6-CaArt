package com.softeer.caart.domain.recommendation.persona;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;

class PersonaRepositoryTest extends RepositoryTest {

	@Autowired
	private PersonaRepository personaRepository;

	@Test
	@DisplayName("페르소나의 데이터를 조회한다")
	void list() {
		assertThat(personaRepository).isNotNull();

		String personaName = "김현대";
		Long personaId = 1L;

		Optional<Persona> persona = personaRepository.findById(personaId);

		// TODO: 쿼리 최적화
		softly.assertThat(persona.isPresent()).isTrue();
		softly.assertThat(persona.get().getProfile().getName()).isEqualTo(personaName);
	}
}
