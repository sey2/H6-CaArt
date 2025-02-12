package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.BodyType;

import lombok.Getter;

@Getter
public class BodyTypeDto {

	private final Long bodyTypeId;
	private final String bodyTypeName;
	private final Integer bodyTypePrice;

	public BodyTypeDto(BodyType bodyType) {
		this.bodyTypeId = bodyType.getId();
		this.bodyTypeName = bodyType.getName();
		this.bodyTypePrice = 0;
	}
}
