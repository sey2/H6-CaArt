package com.softeer.caart.domain.trim.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.trim.entity.Trim;

class TrimRepositoryTest extends RepositoryTest {
	@Test
	@DisplayName("르블랑 트림의 이름이 'Le Blanc'인지 확인한다")
	void getMainOptionOfLeBlanc() {
		// given
		Long LeBlancId = trimRepository.save(LeBlanc).getId();

		// when
		Optional<Trim> LeBlanc = trimRepository.findById(LeBlancId);

		// // then
		softly.assertThat(LeBlanc.get().getName()).isEqualTo("Le Blanc");
	}
}