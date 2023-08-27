package com.softeer.caart.domain.option.dto;

import java.util.List;

import com.softeer.caart.domain.option.dto.response.BaseOptionResponse;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AdditionalOptionDetailsDto {
	private Long optionId;
	private String optionName;
	private Integer optionPrice;
	private String description;
	private String summary;
	private String badge;
	private int adoptionRate;
	private PositionResponse position;
	private String optionImage;
	private List<String> tags;
	private List<BaseOptionResponse> subOptions;

	private AdditionalOptionDetailsDto(AdditionalOptionInfo option, double adoptionRate, PositionResponse position) {
		this.optionId = option.getId();
		this.optionPrice = option.getPrice();
		this.summary = option.getSummary();
		this.badge = option.getBadgeName();
		this.adoptionRate = (int)adoptionRate;
		this.position = position;
		BaseOptionInfo details = option.getDetails();
		this.optionName = details.getName();
		this.description = details.getDescription();
		this.optionImage = details.getImage().getUrl();
		this.tags = option.getTagNames();
		this.subOptions = option.getSubOptions();
	}

	public static AdditionalOptionDetailsDto from(AdditionalOptionInfo option, double adoptionRate,
		PositionResponse position) {
		return new AdditionalOptionDetailsDto(option, adoptionRate, position);
	}
}
