package com.softeer.caart.domain.color.service;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softeer.caart.domain.color.dto.ColorDto;
import com.softeer.caart.domain.color.dto.ColorResponse;
import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.domain.trim.repository.TrimRepository;

class ColorServiceTest extends ServiceTest {

	@InjectMocks
	ColorService colorService;

	@Mock
	TrimRepository trimRepository;

	@Mock
	Trim leBlancMock;
	@Mock
	Trim exclusiveMock;
	@Mock
	Color exteriorColorMock1;
	@Mock
	Color interiorColorMock1;
	@Mock
	Color exteriorColorMock2;
	@Mock
	Color interiorColorMock2;

	@Test
	@DisplayName("")
	void getColors() {
		// given
		Long currentTrimId = LeBlanc.getId();
		AgeGroup ageGroup = AgeGroup.TWENTY;

		// doReturn(List.of(availableColor1, availableColor2)).when(LeBlanc).getAvailableColors();
		// doReturn(List.of(availableColor3, availableColor4)).when(Exclusive).getAvailableColors();
		doReturn(List.of(LeBlanc, Exclusive)).when(trimRepository).findTrimsWithColors();

		// when
		ColorResponse colorResponse = colorService.getColors(currentTrimId, ageGroup);

		// then
		softly.assertThat(colorResponse.getTrimId()).isEqualTo(currentTrimId);
		softly.assertThat(colorResponse.getExteriorColors()).hasSize(1);
		softly.assertThat(colorResponse.getOtherTrimExteriorColors()).hasSize(1);
		ColorDto.ExteriorColorDto exteriorColorDto = colorResponse.getExteriorColors().get(0);
		softly.assertThat(exteriorColorDto.getColorId()).isEqualTo(availableColor1.getColor().getId());
	}
}
