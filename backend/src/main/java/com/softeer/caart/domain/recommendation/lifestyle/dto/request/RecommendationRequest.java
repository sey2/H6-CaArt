package com.softeer.caart.domain.recommendation.lifestyle.dto.request;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Question.*;
import static com.softeer.caart.global.ResultCode.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;
import com.softeer.caart.domain.recommendation.lifestyle.exception.InvalidBudgetException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
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

	@NotNull(message = "minBudget은 필수입니다.")
	@Min(value = 42000000, message = "budget의 최소 범위는 42000000입니다.")
	private final Integer minBudget;

	@NotNull(message = "minBudget은 필수입니다.")
	@Max(value = 69000000, message = "budget의 최대 범위는 69000000입니다.")
	private final Integer maxBudget;

	public void validate() {
		validateAnswer();
		validateBudget();
	}

	private void validateBudget() {
		if (minBudget > maxBudget) {
			throw new InvalidBudgetException(INVALID_BUDGET);
		}
	}

	private void validateAnswer() {
		experience.validateAnswer(EXPERIENCE);
		family.validateAnswer(FAMILY);
		purpose.validateAnswer(PURPOSE);
		value.validateAnswer(VALUE);
	}
}
