package com.softeer.caart.domain.option.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.option.dto.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.BasicOptionResponse;
import com.softeer.caart.domain.option.service.OptionService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/options")
@RequiredArgsConstructor
@Tag(name = "옵션 API", description = "")
public class OptionController {
	private final OptionService optionService;

	@Operation(summary = "기본 옵션의 세부 정보를 조회한다", description = "")
	@GetMapping("/basic")
	public ResponseDto getBasicOption(@RequestParam Long optionId) {
		BasicOptionResponse basicOption = optionService.getBasicOption(optionId);
		return DataResponseDto.of(basicOption);
	}

	@Operation(summary = "추가 옵션의 세부 정보를 조회한다", description = "태그와 옵션은 이름 순으로 오름차순 정렬한다")
	@GetMapping("/additional")
	public ResponseDto getAdditionalOption(@RequestParam Long optionId) {
		AdditionalOptionResponse additionalOption = optionService.getAdditionalOption(optionId);
		return DataResponseDto.of(additionalOption);
	}
}
