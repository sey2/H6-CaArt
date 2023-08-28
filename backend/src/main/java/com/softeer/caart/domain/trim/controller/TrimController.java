package com.softeer.caart.domain.trim.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.trim.dto.response.TrimResponse;
import com.softeer.caart.domain.trim.service.TrimService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/trims")
@RequiredArgsConstructor
@Tag(name = "트림 API", description = "Le Blanc, Exclusive, Prestige, Caligraphy")
public class TrimController {
	private final TrimService trimService;

	@Operation(summary = "모든 트림 정보를 조회한다.")
	@GetMapping
	public ResponseDto getTrims() {
		List<TrimResponse> trims = trimService.getTrims();
		return DataResponseDto.of(trims);
	}
}

