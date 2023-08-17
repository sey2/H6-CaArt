package com.softeer.caart.domain.recommendation.persona.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaRecommendationResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.exception.PersonaNotFoundException;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;
import com.softeer.caart.global.ResultCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {

	private final PersonaRepository personaRepository;

	public List<PersonaResponse> getPersonas() {
		return personaRepository.findAll()
			.stream()
			.map(PersonaResponse::from)
			.collect(Collectors.toList());
	}

	public PersonaDetailsResponse getPersona(Long personaId) {
		Persona persona = personaRepository.findById(personaId)
			.orElseThrow(() -> new PersonaNotFoundException(ResultCode.PERSONA_NOT_FOUND));
		return PersonaDetailsResponse.from(persona);
	}

	public PersonaRecommendationResponse getPersonaRecommendation(Long personaId, Integer age) {
		// TODO: 연령대(age)에 따른 색상 추천
		Persona persona = personaRepository.findById(personaId)
			.orElseThrow(() -> new PersonaNotFoundException(ResultCode.PERSONA_NOT_FOUND));
		return PersonaRecommendationResponse.from(persona);
	}
}
