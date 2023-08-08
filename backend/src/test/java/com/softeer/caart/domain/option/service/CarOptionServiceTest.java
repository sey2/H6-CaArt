package com.softeer.caart.domain.option.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.option.dto.CarOptionResponse;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.CarOptionRepository;
import com.softeer.caart.global.ResultCode;

class CarOptionServiceTest extends ServiceTest {
	@InjectMocks
	private CarOptionService carOptionService;

	@Mock
	private CarOptionRepository carOptionRepository;

	@Nested
	class getOption {
		@Test
		@DisplayName("존재하지 않는 옵션에 접근한 경우 예외를 던진다")
		void optionNotFound() {
			// given, when
			doReturn(Optional.empty()).when(carOptionRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> carOptionService.getOption(-1L))
				.isInstanceOf(OptionNotFoundException.class)
				.hasMessage(ResultCode.OPTION_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("옵션의 세부 정보를 조회한다")
		void success_getOption() {
			// given
			doReturn(Optional.of(옵션)).when(carOptionRepository).findById(any(Long.class));

			// when
			final CarOptionResponse optionResponse = carOptionService.getOption(-1L);

			// then
			softly.assertThat(optionResponse.getName()).isEqualTo(옵션.getName());
		}

		@Test
		@DisplayName("세트 옵션인 경우 자식 옵션을 가져온다")
		void success_getSetOption() {
			// given
			doReturn(Optional.of(세트옵션)).when(carOptionRepository).findById(any(Long.class));

			// when
			final CarOptionResponse optionResponse = carOptionService.getOption(-1L);

			// then
			softly.assertThat(optionResponse.getChildOptions().size()).isGreaterThanOrEqualTo(0);
		}
	}
}