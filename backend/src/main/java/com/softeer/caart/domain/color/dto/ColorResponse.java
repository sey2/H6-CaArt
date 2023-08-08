package com.softeer.caart.domain.color.dto;

import com.softeer.caart.domain.color.entity.Color;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ColorResponse {
	private Long id;
	private String name;
	private Integer price;
	private String image;

	private ColorResponse(Color color) {
		this.id = color.getId();
		this.name = color.getName();
		this.price = color.getPrice();
		this.image = color.getImage().getUrl();
	}

	public static ColorResponse from(Color color) {
		return new ColorResponse(color);
	}
}
