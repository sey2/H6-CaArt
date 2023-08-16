package com.softeer.caart.domain.recommendation.persona.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Tag(name = "라이프스타일 페르소나 API", description = "페르소나의 목록과 세부 정보를 조회한다.")
public class PersonaController {

	private final PersonaService personaService;

	@GetMapping
	@Operation(summary = "전체 페르소나 목록을 조회한다.")
	public ResponseDto getPersonas() {
		List<PersonaResponse> personas = personaService.getPersonas();
		return DataResponseDto.of(personas);
	}
}
