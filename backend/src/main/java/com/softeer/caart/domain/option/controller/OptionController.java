package com.softeer.caart.domain.option.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.option.dto.request.OptionListRequest;
import com.softeer.caart.domain.option.dto.request.OptionSummaryListRequest;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionSummaryResponse;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionsResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionsResponse;
import com.softeer.caart.domain.option.service.OptionService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/options")
@RequiredArgsConstructor
@Tag(name = "옵션 API", description = "추가 옵션 및 기본 옵션 관련")
public class OptionController {
	private final OptionService optionService;

	@Operation(summary = "해당 모델이 가질 수 있는 기본 포함 옵션 목록을 조회한다", description = "이름 순으로 정렬한다")
	@GetMapping("/basic/list")
	public ResponseDto getBasicOptions(OptionListRequest dto) {
		BasicOptionsResponse basicOptions = optionService.getBasicOptions(dto);
		return DataResponseDto.of(basicOptions);
	}

	@Operation(summary = "모델이 가질 수 있는 추가 옵션 목록을 조회한다", description = "(현재 LeBlanc만 조회 가능 > trimId : 1) 추가 옵션은 채택률 순으로 정렬한다. 태그가 ALL인 경우 tagId 인자를 넣지 않는다.")
	@GetMapping("/additional/list")
	public ResponseDto getAdditionalOptions(OptionListRequest dto) {
		AdditionalOptionsResponse additionalOptions = optionService.getAdditionalOptions(dto);
		return DataResponseDto.of(additionalOptions);
	}

	@Operation(summary = "모델이 가질 수 있는 추가 옵션의 간단한 정보 목록을 조회한다", description = "추가옵션id와 이름만 response한다")
	@GetMapping("/additional/summary/list")
	public ResponseDto getAdditionalOptionsSummary(OptionSummaryListRequest dto) {
		List<AdditionalOptionSummaryResponse> additionalOptions = optionService.getAdditionalOptionSummaries(
			dto);
		return DataResponseDto.of(additionalOptions);
	}

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
