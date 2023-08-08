package com.softeer.caart.domain.option.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.option.dto.CarOptionResponse;
import com.softeer.caart.domain.option.service.CarOptionService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/options")
@AllArgsConstructor
@Tag(name = "옵션 API", description = "")
public class CarOptionController {
	private final CarOptionService carOptionService;

	@Operation(summary = "옵션의 세부 정보를 조회한다", description = "태그와 옵션은 이름 순으로 오름차순 정렬한다")
	@GetMapping("")
	public ResponseDto getOption(@RequestParam Long optionId) {
		CarOptionResponse option = carOptionService.getOption(optionId);
		return DataResponseDto.of("option", option);
	}
}

