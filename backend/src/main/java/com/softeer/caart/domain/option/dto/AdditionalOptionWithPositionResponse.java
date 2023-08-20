package com.softeer.caart.domain.option.dto;

import java.util.List;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.entity.Position;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AdditionalOptionWithPositionResponse {
	private Long optionId;
	private String optionName;
	private Integer optionPrice;
	private String description;
	private String summary;
	private String badge;
	private Integer adoptionRate;
	private Position position;
	private String optionImage;
	private List<String> tags;
	private List<BaseOptionResponse> subOptions;

	private AdditionalOptionWithPositionResponse(AdditionalOptionInfo option) {
		this.optionId = option.getId();
		this.optionPrice = option.getPrice();
		this.summary = option.getSummary();
		this.badge = option.getBadgeName();
		this.adoptionRate = 70; // FIXME
		// this.position = option.getPosition(); // FIXME
		BaseOptionInfo details = option.getDetails();
		this.optionName = details.getName();
		this.description = details.getDescription();
		this.optionImage = details.getImage().getUrl();
		this.tags = option.getTagNames();
		this.subOptions = option.getSubOptions();
	}

	public static AdditionalOptionWithPositionResponse from(AdditionalOptionInfo option) {
		return new AdditionalOptionWithPositionResponse(option);
	}
}
