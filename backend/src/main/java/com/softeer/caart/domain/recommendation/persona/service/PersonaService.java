package com.softeer.caart.domain.recommendation.persona.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.repository.AvailableColorRepository;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaRecommendationResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.exception.PersonaNotFoundException;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.global.ResultCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaService {

	private final PersonaRepository personaRepository;
	private final AvailableColorRepository availableColorRepository;

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

	public PersonaRecommendationResponse getPersonaRecommendation(Long personaId, Answer age) {
		Persona persona = personaRepository.findById(personaId)
			.orElseThrow(() -> new PersonaNotFoundException(ResultCode.PERSONA_NOT_FOUND));
		Trim recommendedTrim = persona.getRecommendationResult().getModel().getTrim();
		List<AvailableColor> recommendedColorList = new ArrayList<>();
		recommendedColorList.add(getRecommendedColor(recommendedTrim, age, true));
		recommendedColorList.add(getRecommendedColor(recommendedTrim, age, false));
		return PersonaRecommendationResponse.from(persona, recommendedColorList, age);
	}

	private AvailableColor getRecommendedColor(Trim trim, Answer age, Boolean isExterior) {
		switch (age) {
			case TWENTY:
				return availableColorRepository.findAllByTrimAndColor_IsExteriorOrderByAdoptionRateTwentyDesc(trim,
					isExterior).get(0);
			case THIRTY:
				return availableColorRepository.findAllByTrimAndColor_IsExteriorOrderByAdoptionRateThirtyDesc(trim,
					isExterior).get(0);
			case FORTY:
				return availableColorRepository.findAllByTrimAndColor_IsExteriorOrderByAdoptionRateFortyDesc(trim,
					isExterior).get(0);
			case FIFTY_OR_ABOVE:
				return availableColorRepository.findAllByTrimAndColor_IsExteriorOrderByAdoptionRateFiftyOrAboveDesc(
					trim, isExterior).get(0);
			default:
				return availableColorRepository.findAllByTrimAndColor_IsExteriorOrderByAdoptionRateAllDesc(trim,
					isExterior).get(0);
		}
	}
}
