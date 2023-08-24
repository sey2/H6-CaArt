package com.softeer.caart.domain.recommendation.lifestyle.dto;

import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.composition.dto.BodyTypeDto;
import com.softeer.caart.domain.composition.dto.CarEngineDto;
import com.softeer.caart.domain.composition.dto.WheelDriveDto;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.trim.dto.TrimDto;

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
		private final String modelName = "팰리세이드";
		private final Integer modelPrice;
		private final TrimDto trim;
		private final CarEngineDto engine;
		private final WheelDriveDto wheelDrive;
		private final BodyTypeDto bodyType;

		private RecommendedModelDto(Model model) {
			this.modelPrice = model.calcModelPrice();
			this.trim = new TrimDto(model.getTrim());
			this.engine = new CarEngineDto(model.getCarEngine());
			this.wheelDrive = new WheelDriveDto(model.getWheelDrive());
			this.bodyType = new BodyTypeDto(model.getBodyType());
		}

		public static RecommendedModelDto from(Model model) {
			return new RecommendedModelDto(model);
		}
	}

	@Getter
	public static class RecommendedOptionDto {
		private final String optionImage;
		private final String optionName;
		private final Integer optionPrice;
		private final String recommendationMessage;

		private RecommendedOptionDto(AdditionalOptionInfo optionInfo, String reason) {
			BaseOptionInfo baseInfo = optionInfo.getDetails();
			this.optionImage = baseInfo.getImage().getUrl();
			this.optionName = baseInfo.getName();
			this.optionPrice = optionInfo.getPrice();
			this.recommendationMessage = reason;
		}

		public static RecommendedOptionDto of(AdditionalOptionInfo optionInfo, String reason) {
			return new RecommendedOptionDto(optionInfo, reason);
		}
	}
}
