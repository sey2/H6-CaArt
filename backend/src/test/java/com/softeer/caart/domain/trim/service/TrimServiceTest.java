package com.softeer.caart.domain.trim.service;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.trim.dto.TrimResponse;
import com.softeer.caart.domain.trim.repository.TrimRepository;

class TrimServiceTest extends ServiceTest {
	@InjectMocks
	private TrimService trimService;

	@Mock
	private TrimRepository trimRepository;

	@Test
	@DisplayName("트림 정보를 가져온다")
	void getTrims() {
		// given
		doReturn(List.of(LeBlanc, Exclusive)).when(trimRepository).findAll();

		// when
		List<TrimResponse> trims = trimService.getTrims();

		// then
		softly.assertThat(trims.size()).isEqualTo(2);
	}

	@Test
	@DisplayName("트림의 가격 순으로 정렬해서 트림 정보를 가져온다")
	void getTrimsOrderByTrimPrice() {
		// given
		doReturn(List.of(LeBlanc, Exclusive)).when(trimRepository).findAll();

		// when
		List<TrimResponse> trims = trimService.getTrims();

		// then
		softly.assertThat(trims.get(1).getPrice()).isGreaterThan(trims.get(0).getPrice());
	}
}