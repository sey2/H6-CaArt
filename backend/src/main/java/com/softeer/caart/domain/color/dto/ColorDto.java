package com.softeer.caart.domain.color.dto;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.trim.entity.Trim;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColorDto {

	@Getter
	public static class ColorSummaryDto {
		private final Long colorId;
		private final String colorName;
		private final String colorImage;
		private final Integer colorPrice;

		public ColorSummaryDto(Color color) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
		}
	}

	@Getter
	public static class ExteriorColorDto {
		private final Long colorId;
		private final String colorName;
		private final String colorImage;
		private final Integer colorPrice;
		private final Double adoptionRate;
		private final List<String> previews;

		public ExteriorColorDto(Color color) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
			this.adoptionRate = 60.0;    // TODO: 채택률 계산 로직 추가
			this.previews = color.getImageUrlsOfColorPreview();
		}
	}

	@Getter
	public static class InteriorColorDto {
		private final Long colorId;
		private final String colorName;
		private final String colorImage;
		private final Integer colorPrice;
		private final Double adoptionRate;
		private final String preview;

		public InteriorColorDto(Color color) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
			this.adoptionRate = 60.0;    // TODO: 채택률 계산 로직 추가
			this.preview = color.getImageUrlOfFirstColorPreview();
		}
	}

	@Getter
	public static class OtherTrimColorDto {
		private final Long trimId;
		private final String trimName;
		private final Integer trimPrice;
		private final List<ColorSummaryDto> colors;

		public OtherTrimColorDto(Trim trim) {
			this.trimId = trim.getId();
			this.trimName = trim.getName();
			this.trimPrice = trim.getPrice();
			this.colors = new ArrayList<>();
		}

		public void addColor(Color color) {
			colors.add(new ColorDto.ColorSummaryDto(color));
		}
	}
}
