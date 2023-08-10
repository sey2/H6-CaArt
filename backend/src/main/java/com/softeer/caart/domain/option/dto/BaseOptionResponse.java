package com.softeer.caart.domain.option.dto;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BaseOptionResponse {
	private String name;
	private String description;
	private String image;

	private BaseOptionResponse(BaseOptionInfo option) {
		this.name = option.getName();
		this.description = option.getDescription();
		this.image = option.getImage().getUrl();
	}

	public static BaseOptionResponse from(BaseOptionInfo option) {
		return new BaseOptionResponse(option);
	}
}
