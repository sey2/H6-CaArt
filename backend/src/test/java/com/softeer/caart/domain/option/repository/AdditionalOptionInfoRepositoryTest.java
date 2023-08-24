package com.softeer.caart.domain.option.repository;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;

class AdditionalOptionInfoRepositoryTest extends RepositoryTest {
	@Autowired
	private AdditionalOptionInfoRepository additionalOptionInfoRepository;
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
	@DisplayName("추천 가장 많이 받은 modelId의 설문들 중에 추천 가장 많이 받은 옵션 2개 가져오기")
	void findMostRecommendedOptionByCondition() {
		// given
		Long mostRecommendedModelId = 1L;

		// when
		List<AdditionalOptionInfo> infos = additionalOptionInfoRepository.findMostRecommendedOptionByCondition(
			request.getExperience(),
			request.getFamily(), request.getPurpose(), request.getValue(), request.getMinBudget(),
			request.getMaxBudget(), mostRecommendedModelId);

		// then
		softly.assertThat(infos.size()).isEqualTo(2);
	}
}