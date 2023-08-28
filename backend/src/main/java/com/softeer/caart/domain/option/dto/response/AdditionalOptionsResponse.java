package com.softeer.caart.domain.option.dto.response;

import java.util.List;

import com.softeer.caart.domain.option.dto.AdditionalOptionDetailsDto;

import lombok.Getter;

@Getter
public class AdditionalOptionsResponse {
	private final Long totalElements;
	private final Integer totalPages;
	private final List<AdditionalOptionDetailsDto> additionalOptions;

	private AdditionalOptionsResponse(Long totalElements, Integer totalPages,
		List<AdditionalOptionDetailsDto> additionalOptionDetails) {
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.additionalOptions = additionalOptionDetails;
	}

	public static AdditionalOptionsResponse from(Long totalElements, Integer totalPages,
		List<AdditionalOptionDetailsDto> additionalOptionDetails) {
		return new AdditionalOptionsResponse(totalElements, totalPages, additionalOptionDetails);
	}
}
