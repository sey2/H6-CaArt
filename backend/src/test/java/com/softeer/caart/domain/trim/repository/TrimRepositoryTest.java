package com.softeer.caart.domain.trim.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.common.RepositoryTest;
import com.softeer.caart.domain.trim.entity.Trim;

class TrimRepositoryTest extends RepositoryTest {

	@Autowired
	protected TrimRepository trimRepository;

	@Test
	@DisplayName("르블랑 트림의 이름이 'Le Blanc'인지 확인한다")
	void getMainOptionOfLeBlanc() {
		// given
		String leBlancName = "Le Blanc";
		Long leBlancId = 1L;

		// when
		Optional<Trim> leBlanc = trimRepository.findById(leBlancId);

		// then
		softly.assertThat(leBlanc.isPresent()).isTrue();
		softly.assertThat(leBlanc.get().getName()).isEqualTo(leBlancName);
	}
}
