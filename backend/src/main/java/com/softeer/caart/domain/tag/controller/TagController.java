package com.softeer.caart.domain.tag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softeer.caart.domain.tag.service.TagService;
import com.softeer.caart.global.response.DataResponseDto;
import com.softeer.caart.global.response.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
@Tag(name = "태그 API", description = "")
public class TagController {
	private final TagService tagService;

	@Operation(summary = "태그의 목록을 조회한다.", description = "태그는 이름을 기준으로 오름차순 정렬한다")
	@GetMapping("")
	public ResponseDto getTags() {
		return DataResponseDto.of("tags", tagService.getTags());
	}
}

