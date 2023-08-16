package com.softeer.caart.domain.recommendation.persona.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;

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
}
