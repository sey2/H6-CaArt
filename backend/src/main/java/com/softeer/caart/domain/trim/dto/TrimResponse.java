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
	private String trimName;
	private String description;
	private String trimImage;
	private Integer trimPrice;
	private List<MainOptionResponse> mainOptions;
	private List<ColorResponse> exteriorColors;
	private List<ColorResponse> interiorColors;

	private TrimResponse(Trim trim) {
		this.trimName = trim.getName();
		this.description = trim.getDescription();
		this.trimImage = trim.getImage().getUrl();
		this.trimPrice = trim.getPrice();
		this.mainOptions = trim.getMainOptions().stream()
			.map(MainOptionResponse::from)
			.collect(Collectors.toList());
		this.exteriorColors = trim.getColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isExteriorColor)
			.map(ColorResponse::from)
			.sorted(Comparator.comparing(ColorResponse::getColorName))
			.collect(Collectors.toList());
		this.interiorColors = trim.getColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isInteriorColor)
			.map(ColorResponse::from)
			.sorted(Comparator.comparing(ColorResponse::getColorName))
			.collect(Collectors.toList());
	}

	public static TrimResponse from(Trim trim) {
		return new TrimResponse(trim);
	}
}
