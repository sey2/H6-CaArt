package com.softeer.caart.domain.recommendation.persona.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.recommendation.persona.entity.Persona;
import com.softeer.caart.domain.recommendation.persona.entity.Profile;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PersonaDetailsResponse {

	private final Long personaId;
	private final List<String> tags;
	private final CoverDto cover;
	private final ProfileDto profile;
	private final RecommendationDto recommendation;
	private final List<InterviewDto> interviews;

	private PersonaDetailsResponse(Persona persona) {
		this.personaId = persona.getId();
		this.tags = persona.getTagNameList();
		this.cover = new CoverDto(persona.getCoverLetter(), persona.getCoverImage());
		this.profile = new ProfileDto(persona.getProfile());
		this.recommendation = new RecommendationDto(persona.getRecommendationResult());
		this.interviews = persona.getInterviewList();
	}

	public static PersonaDetailsResponse from(Persona persona) {
		return new PersonaDetailsResponse(persona);
	}

	@Getter
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	private static class CoverDto {
		private final String letter;
		private final String image;
	}

	@Getter
	private static class ProfileDto {
		private final String image;
		private final String name;
		private final String bio;
		private final String message;

		private ProfileDto(Profile profile) {
			this.image = profile.getImage();
			this.name = profile.getName();
			this.bio = profile.getBio();
			this.message = profile.getMessage();
		}
	}

	@Getter
	@Builder
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public static class InterviewDto {
		private final String question;
		private final String answer;
	}

	@Getter
	private static class RecommendationDto {
		private final ModelDto model;
		private final List<OptionDto> options;

		private RecommendationDto(RecommendationResult recommendationResult) {
			this.model = new ModelDto(recommendationResult.getModel());
			this.options = recommendationResult.getRecommendedOptionList().stream()
				.map(option -> new OptionDto(option.getDetails()))
				.collect(Collectors.toList());
		}

		@Getter
		private static class ModelDto {
			private final String trimImage;
			private final String trimName;
			private final String compositions;

			private ModelDto(Model model) {
				this.trimImage = model.getTrim().getImage().getUrl();
				this.trimName = model.getTrim().getName();
				this.compositions = String.join(" ",
					model.getCarEngine().getName(),
					model.getBodyType().getName(),
					model.getWheelDrive().getName());
			}
		}

		@Getter
		private static class OptionDto {
			private final String optionImage;
			private final String optionName;

			private OptionDto(BaseOptionInfo baseOptionInfo) {
				this.optionImage = baseOptionInfo.getImage().getUrl();
				this.optionName = baseOptionInfo.getName();
			}
		}
	}
}
