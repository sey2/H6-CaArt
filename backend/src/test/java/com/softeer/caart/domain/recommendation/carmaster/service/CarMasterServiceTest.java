package com.softeer.caart.domain.recommendation.carmaster.service;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.recommendation.carmaster.dto.CreateSurveyRequest;
import com.softeer.caart.global.ResultCode;

class CarMasterServiceTest extends ServiceTest {
	@InjectMocks
	private CarMasterService carMasterService;
	@Mock
	private ModelRepository modelRepository;

	private CreateSurveyRequest request;

	@BeforeEach
	void initRequest() {
		request = new CreateSurveyRequest(ONE_YEAR, SINGLE, COMMUTING, DESIGN, -1L, -1L, -1L, -1L, -1L, "사유1사유1", -1L,
			"사유2사유2", 0);
	}

	@Nested
	class SaveSurVey {
		@Test
		@DisplayName("모델이 존재하지 않으면 예외를 던진다")
		void trimNotFound() {
			// given, when
			doReturn(Optional.empty()).when(modelRepository)
				.findModelByTrimIdAndCompositionsId(any(Long.class), any(Long.class), any(Long.class), any(Long.class));

			// then
			assertThatThrownBy(() -> carMasterService.saveSurvey(request))
				.isInstanceOf(ModelNotFoundException.class)
				.hasMessage(ResultCode.MODEL_NOT_FOUND.getMessage());
		}
	}
}