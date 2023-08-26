package com.softeer.caart.domain.recommendation.persona.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.repository.AvailableColorRepository;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaRecommendationResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;
import com.softeer.caart.domain.recommendation.persona.exception.PersonaNotFoundException;
import com.softeer.caart.domain.recommendation.persona.repository.PersonaRepository;
import com.softeer.caart.domain.recommendation.persona.repository.RecommendationResultRepository;
import com.softeer.caart.global.ResultCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonaService {

	private final PersonaRepository personaRepository;
	private final RecommendationResultRepository recommendationResultRepository;
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

	public PersonaRecommendationResponse getPersonaRecommendation(Long personaId, AgeGroup ageGroup) {
		RecommendationResult recommendationResult = recommendationResultRepository.findByPersona_Id(personaId)
			.orElseThrow(() -> new PersonaNotFoundException(ResultCode.PERSONA_NOT_FOUND));
		Long recommendedTrimId = recommendationResult.getModel().getTrim().getId();
		List<AvailableColor> recommendedColorList = getRecommendedColors(recommendedTrimId, ageGroup);
		return PersonaRecommendationResponse.of(recommendationResult, recommendedColorList, ageGroup);
	}

	public List<AvailableColor> getRecommendedColors(Long trimId, AgeGroup ageGroup) {
		List<AvailableColor> recommendedColors = new ArrayList<>();
		AvailableColor recommendedExteriorColor;
		AvailableColor recommendedInteriorColor;
		switch (ageGroup) {
			case TWENTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForTwenty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForTwenty(trimId, false);
				break;
			case THIRTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForThirty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForThirty(trimId, false);
				break;
			case FORTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForForty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForForty(trimId, false);
				break;
			case FIFTY_OR_ABOVE:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForFiftyOrAbove(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForFiftyOrAbove(trimId, false);
				break;
			default:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForAll(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForAll(trimId, false);
				break;
		}
		recommendedColors.add(recommendedExteriorColor);
		recommendedColors.add(recommendedInteriorColor);
		return recommendedColors;
	}
}
