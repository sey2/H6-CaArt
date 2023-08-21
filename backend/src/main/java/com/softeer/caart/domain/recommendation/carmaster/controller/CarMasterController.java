package com.softeer.caart.domain.recommendation.carmaster.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.recommendation.carmaster.dto.CreateSurveyRequest;
import com.softeer.caart.domain.recommendation.carmaster.dto.SurveyResponse;
import com.softeer.caart.domain.recommendation.carmaster.service.CarMasterService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carmasters")
@RequiredArgsConstructor
@Tag(name = "카마스터 API", description = "카마스터 설문을 생성하고 저장한다.")
public class CarMasterController {
	private final CarMasterService carMasterService;

	@GetMapping("surveys")
	@Operation(summary = "카마스터 설문지를 조회한다.")
	public ResponseDto getSurvey() {
		SurveyResponse survey = carMasterService.getSurvey();
		return DataResponseDto.of(survey);
	}

	@PostMapping("surveys")
	@Operation(summary = "카마스터 설문지를 저장한다.", description = "다음 설문 버튼을 누르면 API를 호출해서 설문지를 저장한다. (기획 상 5번 반복)")
	public ResponseDto saveSurvey(@Valid @RequestBody CreateSurveyRequest dto) {
		carMasterService.saveSurvey(dto);
		return ResponseDto.success();
	}
}
