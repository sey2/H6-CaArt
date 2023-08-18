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

	@Operation(summary = "모든 트림 정보를 조회한다.", description = "트림은 가격순으로 오름차순 정렬, 트림이 갖는 메인 옵션, 색상은 이름 순으로 정렬한다. "
		+ "(디자인분류 : 트림 선택_기본, 트림 선택_엔진/바디타입/구동방식 정보 팝업)")
	@GetMapping
	public ResponseDto getTrims() {
		List<TrimResponse> trims = trimService.getTrims();
		return DataResponseDto.of(trims);
	}
}

