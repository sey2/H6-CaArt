package com.softeer.caart.domain.composition.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.composition.dto.CompositionResponse;
import com.softeer.caart.domain.composition.service.CompositionService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/compositions")
@RequiredArgsConstructor
@Tag(name = "차량 구성정보 API", description = "엔진&바디&구동방식")
public class CompositionController {
	private final CompositionService compositionService;

	@Operation(summary = "모든 차량 구성 정보를 조회한다.", description = "(디자인분류 : 트림 선택_기본, 트림 선택_엔진/바디타입/구동방식 정보 팝업)")
	@GetMapping
	public ResponseDto getCompositions() {
		CompositionResponse compositions = compositionService.getCompositionInfos();
		return DataResponseDto.of("compositions", compositions);
	}
}
