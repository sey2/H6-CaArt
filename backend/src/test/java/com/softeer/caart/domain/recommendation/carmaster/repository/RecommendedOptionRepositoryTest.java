package com.softeer.caart.domain.recommendation.carmaster.repository;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;

class RecommendedOptionRepositoryTest extends RepositoryTest {
	@Autowired
	private RecommendedOptionRepository recommendedOptionRepository;

	private RecommendationRequest request;

	@BeforeEach
	void init() {
		request = RecommendationRequest.builder()
			.age(TWENTY)
			.experience(ONE_YEAR)
			.family(SINGLE)
			.purpose(LEISURE)
			.value(PERFORMANCE)
			.minBudget(42000000)
			.maxBudget(69000000)
			.build();
	}

	@Test
	@DisplayName("조건에 맞는 추천 옵션의 추천 사유 리스트를 가져온다.")
	void findRecommendReasonsByCondition() {
		// given
		Long additionalOptionId = 1L;

		// when
		List<String> reasons = recommendedOptionRepository.findRecommendReasonsByCondition(request.getExperience(),
			request.getFamily(), request.getPurpose(), request.getValue(), additionalOptionId);

		// then
		softly.assertThat(reasons.size()).isGreaterThan(0);
		softly.assertThat(reasons.size()).isLessThanOrEqualTo(10);
	}
}