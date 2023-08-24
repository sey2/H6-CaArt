package com.softeer.caart.domain.option.dto.response;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BaseOptionResponse {
	private String optionName;
	private String description;
	private String optionImage;

	private BaseOptionResponse(BaseOptionInfo option) {
		this.optionName = option.getName();
		this.description = option.getDescription();
		this.optionImage = option.getImage().getUrl();
	}

	public static BaseOptionResponse from(BaseOptionInfo option) {
		return new BaseOptionResponse(option);
	}
}
