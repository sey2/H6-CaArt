package com.softeer.caart.domain.recommendation.lifestyle.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.composition.dto.BodyTypeDto;
import com.softeer.caart.domain.composition.dto.CarEngineDto;
import com.softeer.caart.domain.composition.dto.WheelDriveDto;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;
import com.softeer.caart.domain.trim.dto.TrimDto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecommendedDto {

	@Getter
	public static class RecommendedColorDto {
		private final Long colorId;
		private final String colorImage;
		private final boolean isExterior;
		private final String colorName;
		private final int colorPrice;
		private final String colorPreview;
		private final String recommendationMessage;

		public RecommendedColorDto(Color color, int adoptionRate, AgeGroup ageGroup) {
			this.colorId = color.getId();
			this.colorImage = color.getImage().getUrl();
			this.isExterior = color.getIsExterior();
			this.colorName = color.getName();
			this.colorPrice = color.getPrice();
			this.colorPreview = color.getImageUrlOfMainColorPreview();
			this.recommendationMessage = String.format("%d%%의 %s 구매자들이 선택했어요.", adoptionRate, ageGroup.getText());
		}
	}

	public static List<RecommendedColorDto> createRecommendedColorDtoList(
		List<AvailableColor> recommendedColors, AgeGroup ageGroup) {
		return recommendedColors.stream()
			.map(recommendedColor -> new RecommendedColorDto(recommendedColor.getColor(),
				(int)recommendedColor.getAdoptionRate(ageGroup), ageGroup))
			.collect(Collectors.toList());
	}

	@Getter
	public static class RecommendedModelDto {
		private final Long modelId;
		private final String modelName = "팰리세이드";
		private final Integer modelPrice;
		private final TrimDto trim;
		private final CarEngineDto engine;
		private final WheelDriveDto wheelDrive;
		private final BodyTypeDto bodyType;

		private RecommendedModelDto(Model model) {
			this.modelId = model.getId();
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
		private final Long optionId;
		private final String optionImage;
		private final String optionName;
		private final Integer optionPrice;
		private final String recommendationMessage;

		private RecommendedOptionDto(AdditionalOptionInfo optionInfo, String reason) {
			BaseOptionInfo baseInfo = optionInfo.getDetails();
			this.optionId = optionInfo.getId();
			this.optionImage = baseInfo.getImage().getUrl();
			this.optionName = baseInfo.getName();
			this.optionPrice = optionInfo.getPrice();
			this.recommendationMessage = reason;
		}

		public static RecommendedOptionDto of(AdditionalOptionInfo optionInfo, String reason) {
			return new RecommendedOptionDto(optionInfo, reason);
		}
	}

	public static List<RecommendedOptionDto> createRecommendedOptionDtoList(RecommendationResult recommendationResult) {
		List<AdditionalOptionInfo> recommendedOptionList = recommendationResult.getRecommendedOptionList();
		List<String> explanationList = recommendationResult.getExplanationList();
		List<RecommendedOptionDto> recommendedOptionDtoList = new ArrayList<>();
		for (int i = 0; i < recommendedOptionList.size(); i++) {
			recommendedOptionDtoList.add(
				RecommendedOptionDto.of(recommendedOptionList.get(i), explanationList.get(i)));
		}
		return recommendedOptionDtoList;
	}
}
