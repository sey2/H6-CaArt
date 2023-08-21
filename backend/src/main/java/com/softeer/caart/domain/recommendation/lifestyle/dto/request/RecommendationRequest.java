package com.softeer.caart.domain.recommendation.lifestyle.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendationRequest {

	@NotNull(message = "age는 필수입니다.")
	private final Answer age;

	@NotNull(message = "experience는 필수입니다.")
	private final Answer experience;

	@NotNull(message = "family는 필수입니다.")
	private final Answer family;

	@NotNull(message = "purpose는 필수입니다.")
	private final Answer purpose;

	@NotNull(message = "value는 필수입니다.")
	private final Answer value;

	@NotNull(message = "budget은 필수입니다.")
	@Min(value = 4200, message = "budget의 최소 범위는 4200입니다.")
	@Max(value = 6900, message = "budget의 최대 범위는 6900입니다.")
	private final Integer budget;
}
