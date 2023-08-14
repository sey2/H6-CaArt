package com.softeer.caart.domain.option.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BasicOptionResponse {
	private String optionName;
	private String description;
	private String optionImage;
	private List<String> tags;

	private BasicOptionResponse(BaseOptionInfo option) {
		this.optionName = option.getName();
		this.description = option.getDescription();
		this.optionImage = option.getImage().getUrl();
		this.tags = option.getTags().stream()
			.map(optionTag -> optionTag.getTag().getName())
			.sorted()
			.collect(Collectors.toList());
	}

	public static BasicOptionResponse from(BaseOptionInfo option) {
		return new BasicOptionResponse(option);
	}
}
