package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

import lombok.Getter;

@Getter
public class RecommendationResponse {

	private final String palisadeImage;
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private RecommendationResponse(RecommendationResult recommendationResult) {
		this.palisadeImage = recommendationResult.getPalisageImage();
		this.model = new RecommendedModelDto(recommendationResult.getModel());
		this.colors = recommendationResult.getRecommendedColorList().stream()
			.map(RecommendedColorDto::new)
			.collect(Collectors.toList());
		this.options = recommendationResult.getRecommendedOptionList().stream()
			.map(RecommendedOptionDto::new)
			.collect(Collectors.toList());
		this.totalPrice = recommendationResult.calcTotalPrice();
	}

	public static RecommendationResponse from(RecommendationResult recommendationResult) {
		return new RecommendationResponse(recommendationResult);
	}
}
