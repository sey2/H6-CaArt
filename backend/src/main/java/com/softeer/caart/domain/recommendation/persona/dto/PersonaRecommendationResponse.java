package com.softeer.caart.domain.recommendation.persona.dto;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
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

	private PersonaRecommendationResponse(Persona persona, List<AvailableColor> recommendedColorList, Answer age) {
		RecommendationResult recommendationResult = persona.getRecommendationResult();
		this.palisadeImage = recommendationResult.getPalisageImage();
		this.recommendationCard = new RecommendationCard(persona);
		this.model = RecommendedModelDto.from(recommendationResult.getModel());
		this.colors = createRecommendedColorDtoList(recommendedColorList, age);
		this.options = createRecommendedOptionDtoList(recommendationResult);
		this.totalPrice = recommendationResult.calcTotalPrice();
	}

	public static PersonaRecommendationResponse from(Persona persona, List<AvailableColor> recommendedColorList,
		Answer age) {
		return new PersonaRecommendationResponse(persona, recommendedColorList, age);
	}

	private List<RecommendedOptionDto> createRecommendedOptionDtoList(RecommendationResult recommendationResult) {
		List<AdditionalOptionInfo> recommendedOptionList = recommendationResult.getRecommendedOptionList();
		List<String> explanationList = recommendationResult.getExplanationList();
		List<RecommendedOptionDto> recommendedOptionDtoList = new ArrayList<>();
		for (int i = 0; i < recommendedOptionList.size(); i++) {
			recommendedOptionDtoList.add(
				RecommendedOptionDto.of(recommendedOptionList.get(i), explanationList.get(i)));
		}
		return recommendedOptionDtoList;
	}

	private List<RecommendedColorDto> createRecommendedColorDtoList(List<AvailableColor> recommendedColorList,
		Answer age) {
		List<RecommendedColorDto> recommendedColorDtoList = new ArrayList<>();
		for (AvailableColor availableColor : recommendedColorList) {
			recommendedColorDtoList.add(
				new RecommendedColorDto(availableColor.getColor(), (int)availableColor.getAdoptionRate(age),
					Answer.getAge(age)));
		}
		return recommendedColorDtoList;
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
