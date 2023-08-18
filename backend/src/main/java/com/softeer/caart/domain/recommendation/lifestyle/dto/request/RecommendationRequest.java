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

	@NotNull(message = "ageId는 필수입니다.")
	private final Long ageId;

	@NotNull(message = "experienceId는 필수입니다.")
	private final Long experienceId;

	@NotNull(message = "familyId는 필수입니다.")
	private final Long familyId;

	@NotNull(message = "purposeId는 필수입니다.")
	private final Long purposeId;

	@NotNull(message = "valueId는 필수입니다.")
	private final Long valueId;

	@NotNull(message = "budget은 필수입니다.")
	@Min(value = 4200, message = "budget의 최소 범위는 4200입니다.")
	@Max(value = 6900, message = "budget의 최대 범위는 6900입니다.")
	private final Integer budget;
}
