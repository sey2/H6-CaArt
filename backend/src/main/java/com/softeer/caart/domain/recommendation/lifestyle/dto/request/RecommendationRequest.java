package com.softeer.caart.domain.recommendation.lifestyle.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendationRequest {

	@NotNull
	private final Long experienceId;

	@NotNull
	private final Long familyId;

	@NotNull
	private final Long purposeId;

	@NotNull
	private final Long valueId;

	@NotNull
	@Min(4200)
	@Max(6900)
	private final Integer budget;
}
