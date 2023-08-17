package com.softeer.caart.domain.recommendation.persona.dto;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonaRecommendationResponse {

	private final String palisadeImage;
	private final RecommendationCard recommendationCard;
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private PersonaRecommendationResponse(Persona persona) {
		RecommendationResult recommendationResult = persona.getRecommendationResult();
		this.palisadeImage = recommendationResult.getPalisageImage();
		this.recommendationCard = new RecommendationCard(persona);
		this.model = new RecommendedModelDto(recommendationResult.getModel());
		this.colors = recommendationResult.getRecommendedColorList().stream()
			.map(RecommendedColorDto::new)
			.collect(Collectors.toList());
		this.options = recommendationResult.getRecommendedOptionList().stream()
			.map(RecommendedOptionDto::new)
			.collect(Collectors.toList());
		this.totalPrice = recommendationResult.calcTotalPrice();
	}

	public static PersonaRecommendationResponse from(Persona persona) {
		return new PersonaRecommendationResponse(persona);
	}

	@Getter
	private static class RecommendationCard {
		private final String slogan;
		private final String message;

		private RecommendationCard(Persona persona) {
			this.slogan = persona.getRecommendationMessage();
			this.message = persona.getProfile().getMessage();
		}
	}
}
