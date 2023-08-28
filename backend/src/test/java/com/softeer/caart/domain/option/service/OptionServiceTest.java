package com.softeer.caart.domain.option.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.request.OptionListRequest;
import com.softeer.caart.domain.option.dto.request.OptionSummaryListRequest;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionsResponse;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.AvailableOptionRepository;
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
	@Mock
	private AvailableOptionRepository availableOptionRepository;

	OptionListRequest invalidRequest = OptionListRequest.builder()
		.tagId(-1L)
		.engineId(-1L)
		.trimId(-1L)
		.wdId(-1L)
		.bodyTypeId(-1L)
		.offset(-1)
		.pageSize(-1)
		.build();
	OptionListRequest request = OptionListRequest.builder()
		.tagId(1L)
		.engineId(1L)
		.trimId(1L)
		.wdId(1L)
		.bodyTypeId(1L)
		.offset(0)
		.pageSize(8)
		.build();

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

		@Test
		@DisplayName("기본 옵션을 상세 조회한다.")
		void getBasicOption() {
			// given
			Long optionId = 1L;
			doReturn(Optional.of(기본옵션O)).when(baseOptionInfoRepository).findById(optionId);

			// when
			BasicOptionResponse basicOption = optionService.getBasicOption(optionId);

			// then
			assertThat(basicOption.getOptionId()).isEqualTo(optionId);
			assertThat(basicOption.getOptionName()).isEqualTo(기본옵션O.getName());
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

		@Test
		@DisplayName("추가 옵션을 상세 조회한다.")
		void getBasicOption() {
			// given
			Long optionId = 추가옵션_세트O_기본X.getId();
			doReturn(Optional.of(추가옵션_세트O_기본X)).when(additionalOptionInfoRepository).findById(optionId);

			// when
			AdditionalOptionResponse additionalOption = optionService.getAdditionalOption(optionId);

			// then
			assertThat(additionalOption.getOptionId()).isEqualTo(optionId);
			assertThat(additionalOption.getOptionName()).isEqualTo(추가옵션_세트O_기본X.getDetails().getName());
		}
	}

	@Nested
	class GetBasicOptions {

		@Mock
		Page<BaseOptionInfo> baseOptionInfoPage;

		@Test
		@DisplayName("존재하지 않는 모델에 접근하면 예외를 던진다")
		void modelNotFound() {
			// given, when
			doReturn(Optional.empty()).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getBasicOptions(invalidRequest))
				.isInstanceOf(ModelNotFoundException.class)
				.hasMessage(ResultCode.MODEL_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("기본 옵션의 첫 페이지(8개)를 조회한다")
		void getFirstPageOfBasicOptions() {
			// given
			doReturn(Optional.of(추가옵션가지는_모델)).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));
			List<BaseOptionInfo> baseOptionInfos = List.of(기본옵션O, 기본옵션O);
			doReturn(baseOptionInfos.size() / 8 + 1).when(baseOptionInfoPage).getTotalPages();
			doReturn((long)baseOptionInfos.size()).when(baseOptionInfoPage).getTotalElements();
			doReturn(baseOptionInfos).when(baseOptionInfoPage).getContent();
			doReturn(baseOptionInfoPage).when(baseOptionInfoRepository)
				.findByModelIdAndTagId(anyLong(), anyLong(), any(Pageable.class));

			// when
			BasicOptionsResponse basicOptions = optionService.getBasicOptions(request);

			// then
			assertThat(basicOptions.getTotalElements()).isEqualTo(baseOptionInfos.size());
			assertThat(basicOptions.getBaseOptions()).hasSize(baseOptionInfos.size());
		}
	}

	@Nested
	class GetAdditionalOptions {

		@Mock
		Page<AdditionalOptionInfo> additionalOptionInfoPage;

		@Test
		@DisplayName("존재하지 않는 모델에 접근하면 예외를 던진다")
		void modelNotFound() {
			// given, when
			doReturn(Optional.empty()).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOptions(invalidRequest))
				.isInstanceOf(ModelNotFoundException.class)
				.hasMessage(ResultCode.MODEL_NOT_FOUND.getMessage());
		}
	}

	@Nested
	class GetAdditionalOptionSummaries {
		private final OptionSummaryListRequest requestDto = new OptionSummaryListRequest(-1L, -1L, -1L, -1L);

		@Test
		@DisplayName("존재하지 않는 모델에 접근하면 예외를 던진다")
		void modelNotFound() {
			// given, when
			doReturn(Optional.empty()).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> optionService.getAdditionalOptionSummaries(requestDto))
				.isInstanceOf(ModelNotFoundException.class)
				.hasMessage(ResultCode.MODEL_NOT_FOUND.getMessage());
		}
	}
}
