package com.softeer.caart.domain.composition.service;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.composition.dto.response.CompositionResponse;
import com.softeer.caart.domain.composition.repository.BodyTypeRepository;
import com.softeer.caart.domain.composition.repository.CarEngineRepository;
import com.softeer.caart.domain.composition.repository.WheelDriveRepository;

class CompositionServiceTest extends ServiceTest {
	@InjectMocks
	private CompositionService compositionService;

	@Mock
	private CarEngineRepository carEngineRepository;

	@Mock
	private BodyTypeRepository bodyTypeRepository;

	@Mock
	private WheelDriveRepository wheelDriveRepository;

	@Test
	@DisplayName("모든 차량 구성정보를 가져온다")
	void getCompositions() {
		// given
		doReturn(List.of(디젤, 가솔린)).when(carEngineRepository).findAll();
		doReturn(List.of(seven, eight)).when(bodyTypeRepository).findAll();
		doReturn(List.of(WD_2, WD_4)).when(wheelDriveRepository).findAll();

		// when
		CompositionResponse compositions = compositionService.getCompositionInfos();

		// then
		softly.assertThat(compositions.getCarEngines().size()).isEqualTo(2);
		softly.assertThat(compositions.getCarEngines().get(0).getEngineName()).isEqualTo(디젤.getName());
	}
}
