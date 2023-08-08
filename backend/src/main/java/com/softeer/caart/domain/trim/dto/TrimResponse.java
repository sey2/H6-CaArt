package com.softeer.caart.domain.trim.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.color.dto.ColorResponse;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.trim.entity.AvailableColor;
import com.softeer.caart.domain.trim.entity.Trim;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrimResponse {
	private String name;
	private String description;
	private String imageUrl;
	private Integer price;
	private List<MainOptionResponse> mainOptions;
	private List<ColorResponse> exteriorColors;
	private List<ColorResponse> interiorColors;

	private TrimResponse(Trim trim) {
		this.name = trim.getName();
		this.description = trim.getDescription();
		this.imageUrl = trim.getImage().getUrl();
		this.price = trim.getPrice();
		this.mainOptions = trim.getMainOptions().stream()
			.map(MainOptionResponse::from)
			.collect(Collectors.toList());
		this.exteriorColors = trim.getColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isExterior)
			.map(ColorResponse::from)
			.sorted(Comparator.comparing(ColorResponse::getName))
			.collect(Collectors.toList());
		this.interiorColors = trim.getColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isInterior)
			.map(ColorResponse::from)
			.sorted(Comparator.comparing(ColorResponse::getName))
			.collect(Collectors.toList());
	}

	public static TrimResponse from(Trim trim) {
		return new TrimResponse(trim);
	}
}
