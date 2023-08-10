package com.softeer.caart.domain.color.dto;

import com.softeer.caart.domain.color.entity.Color;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ColorResponse {
	private Long colorId;
	private String colorName;
	private Integer colorPrice;
	private String colorImage;

	private ColorResponse(Color color) {
		this.colorId = color.getId();
		this.colorName = color.getName();
		this.colorPrice = color.getPrice();
		this.colorImage = color.getImage().getUrl();
	}

	public static ColorResponse from(Color color) {
		return new ColorResponse(color);
	}
}
