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
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.AdditionalOptionsRequest;
import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.BaseOptionInfoRepository;
import com.softeer.caart.global.ResultCode;

class OptionServiceTest extends ServiceTest {
	@InjectMocks
	private OptionService optionService;
	@Mock
	private BaseOptionInfoRepository baseOptionInfoRepository;
	@Mock
	private AdditionalOptionInfoRepository additionalOptionInfoRepository;
	@Mock
	private ModelRepository modelRepository;

	@Nested
	class GetBasicOption {
		@Test
		@DisplayName("존재하지 않는 옵션에 접근한 경우 예외를 던진다")
		void optionNotFound() {
			// given, when
			doReturn(Optional.empty()).when(baseOptionInfoRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getBasicOption(-1L))
				.isInstanceOf(OptionNotFoundException.class)
				.hasMessage(ResultCode.OPTION_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("기본 옵션이 아닌 경우 예외를 던진다")
		void notBasicOption() {
			// given, when
			doReturn(Optional.of(기본옵션X)).when(baseOptionInfoRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getBasicOption(-1L))
				.isInstanceOf(InvalidOptionException.class)
				.hasMessage(ResultCode.INVALID_BASIC_OPTION.getMessage());
		}
	}

	@Nested
	class GetAdditionalOption {
		@Test
		@DisplayName("존재하지 않는 옵션에 접근한 경우 예외를 던진다")
		void optionNotFound() {
			// given, when
			doReturn(Optional.empty()).when(additionalOptionInfoRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOption(-1L))
				.isInstanceOf(OptionNotFoundException.class)
				.hasMessage(ResultCode.OPTION_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("추가옵션 조회했을 때 기본옵션 여부가 true인 경우 예외를 던진다.")
		void notAdditionalOption() {
			// given, when
			doReturn(Optional.of(추가옵션_세트X_기본O)).when(additionalOptionInfoRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOption(-1L))
				.isInstanceOf(InvalidOptionException.class)
				.hasMessage(ResultCode.INVALID_ADDITIONAL_OPTION.getMessage());
		}

		@Test
		@DisplayName("추가옵션이 세트옵션인 경우 자식옵션이 존재한다")
		void existSubOptionsIfSetOption() {
			// given
			doReturn(Optional.of(추가옵션_세트O_기본X)).when(additionalOptionInfoRepository).findById(any(Long.class));

			// when
			AdditionalOptionResponse optionResponse = optionService.getAdditionalOption(-1L);

			// then
			softly.assertThat(추가옵션_세트O_기본X.isOptionTypeSet()).isTrue();
			softly.assertThat(optionResponse.getSubOptions().size()).isEqualTo(1);
		}
	}

	@Nested
	class GetAdditionalOptions {
		private AdditionalOptionsRequest requestDto = new AdditionalOptionsRequest(-1L, -1L, -1L, -1L, -1L, -1, -1);

		@Test
		@DisplayName("존재하지 않는 모델에 접근하면 예외를 던진다")
		void modelNotFound() {
			// given, when
			doReturn(Optional.empty()).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOptions(requestDto))
				.isInstanceOf(ModelNotFoundException.class)
				.hasMessage(ResultCode.MODEL_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("특정 모델이 가질 수 있는 추가 옵션이 존재하지 않으면 예외를 던진다 (Le Blanc만 선택 가능)")
		void invalidBaseOption() {
			// given, when
			doReturn(Optional.of(추가옵션가지는_모델)).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOptions(requestDto))
				.isInstanceOf(InvalidOptionException.class)
				.hasMessage(ResultCode.INVALID_MODEL_ID.getMessage());
		}
	}
}
