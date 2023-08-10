package com.softeer.caart.domain.option.dto;

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
	private Long id;
	private String name;
	private Integer price;
	private String description;
	private String image;
	private List<String> tags;
	private List<BaseOptionResponse> subOptions;

	private AdditionalOptionResponse(AdditionalOptionInfo option) {
		BaseOptionInfo details = option.getDetails();
		this.id = option.getId();
		this.name = details.getName();
		this.price = option.getPrice();
		this.description = details.getDescription();
		this.image = details.getImage().getUrl();
		this.tags = details.getTags().stream()
			.map(optionTag -> optionTag.getTag().getName())
			.sorted()
			.collect(Collectors.toList());
		this.subOptions = option.getSubOptions().stream()
			.map(subOptionInfo -> BaseOptionResponse.from(subOptionInfo.getDetails()))
			.sorted(Comparator.comparing(BaseOptionResponse::getName))
			.collect(Collectors.toList());
	}

	public static AdditionalOptionResponse from(AdditionalOptionInfo option) {
		return new AdditionalOptionResponse(option);
	}
}
