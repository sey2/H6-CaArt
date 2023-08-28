package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.List;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.model.entity.Model;

import lombok.Getter;

@Getter
public class RecommendationResponse {

	private final String palisadeImage = "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png";
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private RecommendationResponse(Model model, List<AvailableColor> recommendedColorList,
		List<RecommendedOptionDto> recommendedOptionDtoList, AgeGroup ageGroup) {
		this.model = RecommendedModelDto.from(model);
		this.colors = createRecommendedColorDtoList(recommendedColorList, ageGroup);
		this.options = recommendedOptionDtoList;
		this.totalPrice = model.calcModelPrice() + options.get(0).getOptionPrice() + options.get(1).getOptionPrice();
	}

	public static RecommendationResponse of(Model model, List<AvailableColor> recommendedColorList,
		List<RecommendedOptionDto> recommendedOptionDtoList, AgeGroup ageGroup) {
		return new RecommendationResponse(model, recommendedColorList, recommendedOptionDtoList, ageGroup);
	}
}
