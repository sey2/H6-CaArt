package com.softeer.caart.domain.trim.dto;

import com.softeer.caart.domain.option.entity.CarOption;
import com.softeer.caart.domain.trim.entity.MainOptionOfTrim;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MainOptionResponse {
	private Long optionId;
	private String optionName;
	private String optionDescription;
	private String image;

	private MainOptionResponse(MainOptionOfTrim mainOptionOfTrim) {
		final CarOption mainOption = mainOptionOfTrim.getMainOption();
		this.optionId = mainOption.getId();
		this.optionName = mainOption.getName();
		this.optionDescription = mainOption.getDescription();
		this.image = mainOption.getImage().getUrl();
	}

	public static MainOptionResponse from(MainOptionOfTrim mainOptionOfTrim) {
		return new MainOptionResponse(mainOptionOfTrim);
	}
}
