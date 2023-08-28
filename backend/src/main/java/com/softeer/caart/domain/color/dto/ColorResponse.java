package com.softeer.caart.domain.color.dto;

import static com.softeer.caart.domain.color.dto.ColorDto.*;

import java.util.List;

import lombok.Getter;

@Getter
public class ColorResponse {

	private final Long trimId;
	private final List<ExteriorColorDto> exteriorColors;
	private final List<OtherTrimColorDto> otherTrimExteriorColors;
	private final List<InteriorColorDto> interiorColors;
	private final List<OtherTrimColorDto> otherTrimInteriorColors;

	private ColorResponse(
		Long trimId,
		List<ExteriorColorDto> exteriorColors, List<OtherTrimColorDto> otherTrimExteriorColors,
		List<InteriorColorDto> interiorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		this.trimId = trimId;
		this.exteriorColors = exteriorColors;
		this.otherTrimExteriorColors = otherTrimExteriorColors;
		this.interiorColors = interiorColors;
		this.otherTrimInteriorColors = otherTrimInteriorColors;
	}

	public static ColorResponse of(
		Long trimId,
		List<ExteriorColorDto> exteriorColors, List<OtherTrimColorDto> otherTrimExteriorColors,
		List<InteriorColorDto> interiorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		return new ColorResponse(trimId, exteriorColors, otherTrimExteriorColors,
			interiorColors, otherTrimInteriorColors);
	}
}
