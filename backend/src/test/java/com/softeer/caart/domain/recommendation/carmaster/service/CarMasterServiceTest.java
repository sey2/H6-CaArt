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
import com.softeer.caart.domain.composition.exception.BodyTypeNotFoundException;
import com.softeer.caart.domain.composition.exception.EngineNotFoundException;
import com.softeer.caart.domain.composition.exception.WheelDriveNotFoundException;
import com.softeer.caart.domain.composition.repository.BodyTypeRepository;
import com.softeer.caart.domain.composition.repository.CarEngineRepository;
import com.softeer.caart.domain.composition.repository.WheelDriveRepository;
import com.softeer.caart.domain.recommendation.carmaster.dto.CreateSurveyRequest;
import com.softeer.caart.domain.trim.exception.TrimNotFoundException;
import com.softeer.caart.domain.trim.repository.TrimRepository;
import com.softeer.caart.global.ResultCode;

class CarMasterServiceTest extends ServiceTest {
	@InjectMocks
	private CarMasterService carMasterService;
	@Mock
	private TrimRepository trimRepository;
	@Mock
	private CarEngineRepository carEngineRepository;
	@Mock
	private BodyTypeRepository bodyTypeRepository;
	@Mock
	private WheelDriveRepository wheelDriveRepository;

	private CreateSurveyRequest request;

	@BeforeEach
	void initRequest() {
		request = new CreateSurveyRequest(ONE_YEAR, SINGLE, COMMUTING, DESIGN, -1L, -1L, -1L, -1L, -1L, "사유1사유1", -1L,
			"사유2사유2", 0);
	}

	@Nested
	class SaveSurVey {
		@Test
		@DisplayName("트림이 존재하지 않으면 예외를 던진다")
		void trimNotFound() {
			// given, when
			doReturn(Optional.empty()).when(trimRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> carMasterService.saveSurvey(request))
				.isInstanceOf(TrimNotFoundException.class)
				.hasMessage(ResultCode.TRIM_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("엔진이 존재하지 않으면 예외를 던진다")
		void engineNotFound() {
			// given, when
			doReturn(Optional.of(LeBlanc)).when(trimRepository).findById(any(Long.class));
			doReturn(Optional.empty()).when(carEngineRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> carMasterService.saveSurvey(request))
				.isInstanceOf(EngineNotFoundException.class)
				.hasMessage(ResultCode.ENGINE_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("바디타입 존재하지 않으면 예외를 던진다")
		void bodyTypeNotFound() {
			// given, when
			doReturn(Optional.of(LeBlanc)).when(trimRepository).findById(any(Long.class));
			doReturn(Optional.of(디젤)).when(carEngineRepository).findById(any(Long.class));
			doReturn(Optional.empty()).when(bodyTypeRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> carMasterService.saveSurvey(request))
				.isInstanceOf(BodyTypeNotFoundException.class)
				.hasMessage(ResultCode.BODY_TYPE_NOT_FOUND.getMessage());
		}

		@Test
		@DisplayName("구동방식이 존재하지 않으면 예외를 던진다")
		void wheelDriveNotFound() {
			// given, when
			doReturn(Optional.of(LeBlanc)).when(trimRepository).findById(any(Long.class));
			doReturn(Optional.of(디젤)).when(carEngineRepository).findById(any(Long.class));
			doReturn(Optional.of(seven)).when(bodyTypeRepository).findById(any(Long.class));
			doReturn(Optional.empty()).when(wheelDriveRepository).findById(any(Long.class));

			// then
			assertThatThrownBy(() -> carMasterService.saveSurvey(request))
				.isInstanceOf(WheelDriveNotFoundException.class)
				.hasMessage(ResultCode.WHEEL_DRIVE_NOT_FOUND.getMessage());
		}
	}
}