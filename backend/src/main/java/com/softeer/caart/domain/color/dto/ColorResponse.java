package com.softeer.caart.domain.color.dto;

import static com.softeer.caart.domain.color.dto.ColorDto.*;

import java.util.List;

import lombok.Getter;

@Getter
public class ColorResponse {

	private final List<ExteriorColorDto> exteriorColors;
	private final List<OtherTrimColorDto> otherTrimExteriorColors;
	private final List<InteriorColorDto> interiorColors;
	private final List<OtherTrimColorDto> otherTrimInteriorColors;

	private ColorResponse(
		List<ExteriorColorDto> exteriorColors, List<OtherTrimColorDto> otherTrimExteriorColors,
		List<InteriorColorDto> interiorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		this.exteriorColors = exteriorColors;
		this.otherTrimExteriorColors = otherTrimExteriorColors;
		this.interiorColors = interiorColors;
		this.otherTrimInteriorColors = otherTrimInteriorColors;
	}

	public static ColorResponse of(
		List<ExteriorColorDto> exteriorColors, List<OtherTrimColorDto> otherTrimExteriorColors,
		List<InteriorColorDto> interiorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		return new ColorResponse(exteriorColors, otherTrimExteriorColors, interiorColors, otherTrimInteriorColors);
	}
}
