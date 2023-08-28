package com.softeer.caart.domain.recommendation.persona.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaDetailsResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaRecommendationResponse;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;
import com.softeer.caart.domain.recommendation.persona.service.PersonaService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personas")
@Tag(name = "페르소나 API", description = "페르소나의 목록과 세부 정보를 조회한다.")
public class PersonaController {

	private final PersonaService personaService;

	@GetMapping
	@Operation(summary = "전체 페르소나 목록을 조회한다.")
	public ResponseDto getPersonas() {
		List<PersonaResponse> personaResponses = personaService.getPersonas();
		return DataResponseDto.of(personaResponses);
	}

	@GetMapping("/{personaId}")
	@Operation(summary = "아이디로 특정 페르소나를 조회한다.")
	public ResponseDto getPersona(@PathVariable Long personaId) {
		PersonaDetailsResponse personaDetailsResponse = personaService.getPersona(personaId);
		return DataResponseDto.of(personaDetailsResponse);
	}

	@GetMapping("/{personaId}/recommendation")
	@Operation(summary = "페르소나의 추천 차량 견적을 조회한다.")
	public ResponseDto getPersonaRecommendation(@PathVariable final Long personaId, @RequestParam final Answer age) {
		AgeGroup ageGroup = AgeGroup.valueOf(age.name());
		PersonaRecommendationResponse response = personaService.getPersonaRecommendation(personaId, ageGroup);
		return DataResponseDto.of(response);
	}
}
