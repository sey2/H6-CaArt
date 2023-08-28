package com.softeer.caart.domain.model.repository;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;

class ModelRepositoryTest extends RepositoryTest {

	@Autowired
	private ModelRepository modelRepository;
	private RecommendationRequest request;

	@BeforeEach
	void initRequest() {
		request = RecommendationRequest.builder()
			.age(TWENTY)
			.experience(ONE_YEAR)
			.family(SINGLE)
			.purpose(LEISURE)
			.value(PERFORMANCE)
			.minBudget(43000000)
			.maxBudget(69000000)
			.build();
	}

	@Test
	@DisplayName("trimId와 차량 구성정보의 id로 model을 가져온다")
	void findModelByTrimIdAndCompositionsId() {
		// given
		Long trimId = 1L;
		Long engineId = 1L;
		Long bodyTypeId = 1L;
		Long wdId = 1L;
		Long modelId = 1L;

		// when
		Optional<Model> optionalModel = modelRepository.findModelByTrimIdAndCompositionsId(trimId, engineId, bodyTypeId,
			wdId);

		// // then
		softly.assertThat(optionalModel).isNotEmpty();
		softly.assertThat(optionalModel.get().getId()).isEqualTo(modelId);
	}

	@Test
	@DisplayName("추천을 가장 많이 받은 모델 1개를 가져온다")
	void findMostRecommendedModelByCondition() {
		// given, when
		Optional<Model> model = modelRepository.findMostRecommendedModelByCondition(request.getExperience(),
			request.getFamily(),
			request.getPurpose(), request.getValue(),
			request.getMinBudget(), request.getMaxBudget());

		// then
		softly.assertThat(model).isNotEmpty();
	}
}