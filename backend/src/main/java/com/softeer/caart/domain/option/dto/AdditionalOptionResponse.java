package com.softeer.caart.domain.option.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	private String optionImage;
	private List<String> tags;
	private List<BaseOptionResponse> subOptions = new ArrayList<>(); // TODO : 추후 재사용하지 않으면 inner class로 변경

	private AdditionalOptionResponse(AdditionalOptionInfo option) {
		this.optionId = option.getId();
		this.optionPrice = option.getPrice();
		BaseOptionInfo details = option.getDetails();
		this.optionName = details.getName();
		this.description = details.getDescription();
		this.optionImage = details.getImage().getUrl();
		this.tags = details.getTags().stream()
			.map(optionTag -> optionTag.getTag().getName())
			.sorted()
			.collect(Collectors.toList());
		if (option.isOptionTypeSet()) {
			this.subOptions = option.getSubOptions().stream()
				.map(subOptionInfo -> BaseOptionResponse.from(subOptionInfo.getDetails()))
				.sorted(Comparator.comparing(BaseOptionResponse::getOptionName))
				.collect(Collectors.toList());
		}
	}

	public static AdditionalOptionResponse from(AdditionalOptionInfo option) {
		return new AdditionalOptionResponse(option);
	}
}
