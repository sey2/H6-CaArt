package com.softeer.caart.domain.model.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.model.entity.Model;

class ModelRepositoryTest extends RepositoryTest {

	@Autowired
	private ModelRepository modelRepository;

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
}