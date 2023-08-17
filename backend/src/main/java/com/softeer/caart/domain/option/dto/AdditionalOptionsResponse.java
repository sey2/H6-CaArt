package com.softeer.caart.domain.option.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

import lombok.Getter;

@Getter
public class AdditionalOptionsResponse {
	private Long totalElements;
	private Integer totalPages;
	private List<AdditionalOptionWithPositionResponse> additionalOptions;

	private AdditionalOptionsResponse(Page<AdditionalOptionInfo> page) {
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.additionalOptions = page.getContent().stream()
			.map(AdditionalOptionWithPositionResponse::from)
			.collect(Collectors.toList());
	}

	public static AdditionalOptionsResponse from(Page<AdditionalOptionInfo> page) {
		return new AdditionalOptionsResponse(page);
	}
}
