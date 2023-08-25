package com.softeer.caart.domain.color.dto;

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
		private final int colorPrice;
		private final int adoptionRate;
		private final List<String> previews;

		public ExteriorColorDto(Color color, double adoptionRate) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
			this.adoptionRate = (int)adoptionRate;
			this.previews = color.getImageUrlListOfColorPreview();
		}
	}

	@Getter
	public static class InteriorColorDto {
		private final Long colorId;
		private final String colorName;
		private final String colorImage;
		private final int colorPrice;
		private final int adoptionRate;
		private final String preview;

		public InteriorColorDto(Color color, double adoptionRate) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
			this.adoptionRate = (int)adoptionRate;
			this.preview = color.getImageUrlOfMainColorPreview();
		}
	}

	@Getter
	public static class OtherTrimColorDto {
		private final Long colorId;
		private final String colorName;
		private final String colorImage;
		private final Integer colorPrice;
		private final Long trimId;
		private final String trimName;
		private final Integer trimPrice;
		private final String preview;

		public OtherTrimColorDto(Color color, Trim trim) {
			this.colorId = color.getId();
			this.colorName = color.getName();
			this.colorImage = color.getImage().getUrl();
			this.colorPrice = color.getPrice();
			this.trimId = trim.getId();
			this.trimName = trim.getName();
			this.trimPrice = trim.getPrice();
			this.preview = color.getImageUrlOfMainColorPreview();
		}
	}
}
