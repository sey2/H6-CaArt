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
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.OptionRepository;
import com.softeer.caart.global.ResultCode;

class BaseOptionInfoServiceTest extends ServiceTest {
	@InjectMocks
	private OptionService optionService;

	@Mock
	private OptionRepository optionRepository;

	@Nested
	class getOption {
		@Test
		@DisplayName("존재하지 않는 옵션에 접근한 경우 예외를 던진다")
		void optionNotFound() {
			// given, when
			doReturn(Optional.empty()).when(optionRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getOption(-1L))
				.isInstanceOf(OptionNotFoundException.class)
				.hasMessage(ResultCode.OPTION_NOT_FOUND.getMessage());
		}
	}
}
