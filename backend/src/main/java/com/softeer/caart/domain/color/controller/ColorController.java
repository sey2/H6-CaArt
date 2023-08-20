package com.softeer.caart.domain.color.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.color.service.ColorService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/colors")
@RequiredArgsConstructor
@Tag(name = "색상 API", description = "트림의 외장/내장 색상 정보를 조회한다.")
public class ColorController {

	private final ColorService colorService;

	@GetMapping
	@Operation(summary = "{trimId}에 대한 외장/내장 색상 목록을 조회한다.",
		description = "현재 트림에서는 선택 불가능하지만 다른 트림에서 선택 가능한 색상 목록도 함께 응답합니다.")
	public ResponseDto getColors(final @RequestParam @NotNull Long trimId) {
		return DataResponseDto.of(colorService.getColors(trimId));
	}
}
