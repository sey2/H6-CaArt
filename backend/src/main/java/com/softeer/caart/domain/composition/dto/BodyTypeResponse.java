package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.BodyType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BodyTypeResponse {
	private String bodyTypeName;
	private String description;
	private String bodyTypeImage;

	private BodyTypeResponse(BodyType bodyType) {
		this.bodyTypeName = bodyType.getName();
		this.description = bodyType.getDescription();
		this.bodyTypeImage = bodyType.getImage().getUrl();
	}

	public static BodyTypeResponse from(BodyType bodyType) {
		return new BodyTypeResponse(bodyType);
	}
}
