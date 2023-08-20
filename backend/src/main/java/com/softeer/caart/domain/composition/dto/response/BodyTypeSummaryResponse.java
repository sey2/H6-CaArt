package com.softeer.caart.domain.composition.dto.response;

import com.softeer.caart.domain.composition.entity.BodyType;

import lombok.Getter;

@Getter
public class BodyTypeSummaryResponse {
	private final Long bodyTypeId;
	private final String bodyTypeName;

	private BodyTypeSummaryResponse(BodyType bodyType) {
		this.bodyTypeId = bodyType.getId();
		this.bodyTypeName = bodyType.getName();
	}

	public static BodyTypeSummaryResponse from(BodyType bodyType) {
		return new BodyTypeSummaryResponse(bodyType);
	}
}
