package com.softeer.caart.domain.trim.dto;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.trim.entity.MainOptionOfTrim;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MainOptionResponse {
	private Long optionId;
	private String optionName;
	private String description;
	private String optionImage;

	private MainOptionResponse(MainOptionOfTrim mainOptionOfTrim) {
		final BaseOptionInfo mainOption = mainOptionOfTrim.getMainOption();
		this.optionId = mainOption.getId();
		this.optionName = mainOption.getName();
		this.description = mainOption.getDescription();
		this.optionImage = mainOption.getImage().getUrl();
	}

	public static MainOptionResponse from(MainOptionOfTrim mainOptionOfTrim) {
		return new MainOptionResponse(mainOptionOfTrim);
	}
}
