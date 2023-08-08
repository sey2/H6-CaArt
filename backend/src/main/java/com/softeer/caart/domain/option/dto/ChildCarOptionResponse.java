package com.softeer.caart.domain.option.dto;

import com.softeer.caart.domain.option.entity.ChildCarOption;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ChildCarOptionResponse {
	private String name;
	private String description;
	private String image;

	private ChildCarOptionResponse(ChildCarOption option) {
		this.name = option.getName();
		this.description = option.getDescription();
		this.image = option.getImage().getUrl();
	}

	public static ChildCarOptionResponse from(ChildCarOption option) {
		return new ChildCarOptionResponse(option);
	}
}
