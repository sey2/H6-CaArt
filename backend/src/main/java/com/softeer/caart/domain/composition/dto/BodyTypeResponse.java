package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.BodyType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BodyTypeResponse {
	private String name;
	private String description;
	private String image;

	private BodyTypeResponse(BodyType bodyType) {
		this.name = bodyType.getName();
		this.description = bodyType.getDescription();
		this.image = bodyType.getImage().getUrl();
	}

	public static BodyTypeResponse from(BodyType bodyType) {
		return new BodyTypeResponse(bodyType);
	}
}
