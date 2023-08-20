package com.softeer.caart.domain.trim.dto.response;

import com.softeer.caart.domain.trim.entity.Trim;

import lombok.Getter;

@Getter
public class TrimSummaryResponse {
	final private Long trimId;
	final private String trimName;

	private TrimSummaryResponse(Trim trim) {
		this.trimId = trim.getId();
		this.trimName = trim.getName();
	}

	public static TrimSummaryResponse from(Trim trim) {
		return new TrimSummaryResponse(trim);
	}
}
