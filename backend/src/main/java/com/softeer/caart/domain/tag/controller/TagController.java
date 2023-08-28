package com.softeer.caart.domain.tag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.tag.service.TagService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
@Tag(name = "태그 API", description = "")
public class TagController {
	private final TagService tagService;

	@Operation(summary = "기본 포함 옵션의 태그 목록을 조회한다.", description = "태그는 priority를 기준으로 정렬한다. priority는 정렬에만 사용한다")
	@GetMapping("/basic")
	public ResponseDto getBasicTags() {
		return DataResponseDto.of(tagService.getBasicOptionTags());
	}

	@Operation(summary = "추가 옵션의 태그 목록을 조회한다.", description = "태그는 priority를 기준으로 정렬한다. priority는 정렬에만 사용한다")
	@GetMapping("/additional")
	public ResponseDto getAdditionalTags() {
		return DataResponseDto.of(tagService.getAdditionalOptionTags());
	}

}

