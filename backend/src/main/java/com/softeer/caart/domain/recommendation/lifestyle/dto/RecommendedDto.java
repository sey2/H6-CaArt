package com.softeer.caart.domain.recommendation.lifestyle.dto;

import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.model.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecommendedDto {

	@Getter
	public static class RecommendedColorDto {
		private final String colorImage;
		private final Boolean isExterior;
		private final String colorName;
		private final Integer colorPrice;
		private final String recommendationMessage;

		public RecommendedColorDto(Color color) {
			this.colorImage = color.getImage().getUrl();
			this.isExterior = color.getIsExterior();
			this.colorName = color.getName();
			this.colorPrice = color.getPrice();
			this.recommendationMessage = "75%의 20대 구매자들이 선택했어요.";
		}
	}

	@Getter
	public static class RecommendedModelDto {
		private final String modelName;
		private final String trim;
		private final String engine;
		private final String wheelDrive;
		private final String bodyType;
		private final Integer modelPrice;

		public RecommendedModelDto(Model model) {
			this.modelName = "펠리세이드";
			this.trim = model.getTrim().getName();
			this.engine = model.getCarEngine().getName();
			this.wheelDrive = model.getWheelDrive().getName();
			this.bodyType = model.getBodyType().getName();
			this.modelPrice = model.calcModelPrice();
		}
	}

	@Getter
	public static class RecommendedOptionDto {
		private final String optionImage;
		private final String optionName;
		private final Integer optionPrice;
		private final String recommendationMessage;

		public RecommendedOptionDto(AdditionalOptionInfo optionInfo) {
			BaseOptionInfo baseInfo = optionInfo.getDetails();
			this.optionImage = baseInfo.getImage().getUrl();
			this.optionName = baseInfo.getName();
			this.optionPrice = optionInfo.getPrice();
			this.recommendationMessage = "꼭 추가해야 하는 옵션이에요.";
		}
	}

}
