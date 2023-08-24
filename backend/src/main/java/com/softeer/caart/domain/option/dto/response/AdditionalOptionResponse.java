package com.softeer.caart.domain.option.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AdditionalOptionResponse {
	private Long optionId;
	private String optionName;
	private Integer optionPrice;
	private String description;
	private String summary;
	private String optionImage;
	private List<String> tags;
	private List<BaseOptionResponse> subOptions = new ArrayList<>(); // TODO : 추후 재사용하지 않으면 inner class로 변경

	private AdditionalOptionResponse(AdditionalOptionInfo option) {
		this.optionId = option.getId();
		this.optionPrice = option.getPrice();
		this.summary = option.getSummary();
		BaseOptionInfo details = option.getDetails();
		this.optionName = details.getName();
		this.description = details.getDescription();
		this.optionImage = details.getImage().getUrl();
		this.tags = option.getTagNames();
		this.subOptions = option.getSubOptions();
	}

	public static AdditionalOptionResponse from(AdditionalOptionInfo option) {
		return new AdditionalOptionResponse(option);
	}
}
