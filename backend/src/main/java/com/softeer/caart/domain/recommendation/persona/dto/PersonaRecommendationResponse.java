package com.softeer.caart.domain.recommendation.persona.dto;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.List;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
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

	private final Long personaId;
	private final String palisadeImage;
	private final RecommendationCard recommendationCard;
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private PersonaRecommendationResponse(RecommendationResult recommendationResult,
		List<AvailableColor> recommendedColorList, AgeGroup ageGroup) {
		Persona persona = recommendationResult.getPersona();
		this.personaId = persona.getId();
		this.palisadeImage = recommendationResult.getPalisageImage();
		this.recommendationCard = new RecommendationCard(persona);
		this.model = RecommendedModelDto.from(recommendationResult.getModel());
		this.colors = createRecommendedColorDtoList(recommendedColorList, ageGroup);
		this.options = createRecommendedOptionDtoList(recommendationResult);
		this.totalPrice =
			recommendationResult.calcTotalPrice() + colors.stream().mapToInt(RecommendedColorDto::getColorPrice).sum();
	}

	public static PersonaRecommendationResponse of(RecommendationResult recommendationResult,
		List<AvailableColor> recommendedColorList, AgeGroup ageGroup) {
		return new PersonaRecommendationResponse(recommendationResult, recommendedColorList, ageGroup);
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
