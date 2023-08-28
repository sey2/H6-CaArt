package com.softeer.caart.domain.recommendation.lifestyle.dto.request;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softeer.caart.domain.recommendation.lifestyle.exception.InvalidBudgetException;
import com.softeer.caart.global.ResultCode;

class RecommendationRequestTest {
	@Test
	@DisplayName("최소 예산이 최대 예산보다 크면 예외를 던진다")
	void validateBudget() {
		// given, when
		RecommendationRequest dto = RecommendationRequest.builder()
			.age(TWENTY)
			.experience(ONE_YEAR)
			.family(SINGLE)
			.purpose(LEISURE)
			.value(DESIGN)
			.minBudget(43000000)
			.maxBudget(42000000)
			.build();

		// then
		assertThatThrownBy(() -> dto.validate())
			.isInstanceOf(InvalidBudgetException.class)
			.hasMessage(ResultCode.INVALID_BUDGET.getMessage());
	}
}