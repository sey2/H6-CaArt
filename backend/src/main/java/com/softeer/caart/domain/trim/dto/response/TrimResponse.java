package com.softeer.caart.domain.trim.dto.response;

import static com.softeer.caart.domain.color.dto.ColorDto.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.trim.entity.Trim;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrimResponse {
	private Long trimId;
	private String trimName;
	private String description;
	private String trimImage;
	private Integer trimPrice;
	private List<MainOptionResponse> mainOptions;
	private List<ColorSummaryDto> exteriorColors;
	private List<ColorSummaryDto> interiorColors;

	private TrimResponse(Trim trim) {
		this.trimId = trim.getId();
		this.trimName = trim.getName();
		this.description = trim.getDescription();
		this.trimImage = trim.getImage().getUrl();
		this.trimPrice = trim.getPrice();
		this.mainOptions = trim.getMainOptions().stream()
			.map(MainOptionResponse::from)
			.collect(Collectors.toList());
		this.exteriorColors = trim.getAvailableColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isExteriorColor)
			.map(ColorSummaryDto::new)
			.sorted(Comparator.comparing(ColorSummaryDto::getColorName))
			.collect(Collectors.toList());
		this.interiorColors = trim.getAvailableColors().stream()
			.map(AvailableColor::getColor)
			.filter(Color::isInteriorColor)
			.map(ColorSummaryDto::new)
			.sorted(Comparator.comparing(ColorSummaryDto::getColorName))
			.collect(Collectors.toList());
	}

	public static TrimResponse from(Trim trim) {
		return new TrimResponse(trim);
	}
}
