package com.softeer.caart.domain.recommendation.adoption.scheduler;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.MultiValueMap;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.repository.AvailableColorRepository;
import com.softeer.caart.domain.common.ServiceTest;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.PurchasedOptionCountDto;
import com.softeer.caart.domain.option.entity.AvailableOption;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.AvailableOptionRepository;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.global.scheduler.AdoptionRateScheduler;

class AdoptionRateSchedulerTest extends ServiceTest {

	@InjectMocks
	AdoptionRateScheduler adoptionRateScheduler;

	@Mock
	AvailableColorRepository availableColorRepository;
	@Mock
	AdditionalOptionInfoRepository additionalOptionInfoRepository;
	@Mock
	ModelRepository modelRepository;
	@Mock
	AvailableOptionRepository availableOptionRepository;
	@Mock
	PurchasedColorCountDto purchasedColorCountDto1;
	@Mock
	PurchasedColorCountDto purchasedColorCountDto2;
	@Mock
	PurchasedColorCountDto purchasedColorCountDto3;
	@Mock
	PurchasedColorCountDto purchasedColorCountDto4;
	@Mock
	PurchasedOptionCountDto purchasedOptionCountDto;

	List<AvailableColor> availableColors = new ArrayList<>();
	List<PurchasedColorCountDto> purchasedExteriorColorCountDtoList = new ArrayList<>();
	List<PurchasedColorCountDto> purchasedInteriorColorCountDtoList = new ArrayList<>();
	List<PurchasedOptionCountDto> purchasedOptionCountDtoList = new ArrayList<>();

	@Nested
	@DisplayName("색상 채택률 테스트")
	class ColorAdoptionRate {

		@BeforeEach
		void setUp() {
			availableColors.add(AvailableColor.builder().trim(LeBlanc).color(exteriorColor1).build());
			availableColors.add(AvailableColor.builder().trim(LeBlanc).color(exteriorColor2).build());
			availableColors.add(AvailableColor.builder().trim(LeBlanc).color(interiorColor1).build());
			availableColors.add(AvailableColor.builder().trim(LeBlanc).color(interiorColor2).build());
			doReturn(availableColors).when(availableColorRepository).findAll();
		}

		@Test
		@DisplayName("AvailableColor 리스트를 트림에 따른 맵으로 변환한다.")
		void getTrimAvailableColorMap() {
			// given
			// when
			MultiValueMap<Trim, AvailableColor> trimAvailableColorMap = adoptionRateScheduler.getTrimAvailableColorMap();

			// then
			softly.assertThat(trimAvailableColorMap.size()).isEqualTo(1);
			List<AvailableColor> availableColorList = trimAvailableColorMap.get(LeBlanc);
			softly.assertThat(availableColorList.size()).isEqualTo(availableColors.size());
			softly.assertThat(availableColorList.get(0).getColor()).isEqualTo(exteriorColor1);
		}

		@Test
		@DisplayName("색상의 채택률을 업데이트한다.")
		void updateAdoptionRateOfColors() {
			// given
			doReturn(1L).when(purchasedColorCountDto1).getColorId();
			doReturn(6).when(purchasedColorCountDto1).getCount();
			doReturn(2L).when(purchasedColorCountDto2).getColorId();
			doReturn(4).when(purchasedColorCountDto2).getCount();
			purchasedExteriorColorCountDtoList.add(purchasedColorCountDto1);
			purchasedExteriorColorCountDtoList.add(purchasedColorCountDto2);

			doReturn(3L).when(purchasedColorCountDto3).getColorId();
			doReturn(7).when(purchasedColorCountDto3).getCount();
			doReturn(4L).when(purchasedColorCountDto4).getColorId();
			doReturn(3).when(purchasedColorCountDto4).getCount();
			purchasedInteriorColorCountDtoList.add(purchasedColorCountDto3);
			purchasedInteriorColorCountDtoList.add(purchasedColorCountDto4);

			doReturn(purchasedExteriorColorCountDtoList).when(availableColorRepository)
				.countPurchasedExteriorColorByAgeGroup(anyLong(), anyInt(), anyInt());
			doReturn(purchasedInteriorColorCountDtoList).when(availableColorRepository)
				.countPurchasedInteriorColorByAgeGroup(anyLong(), anyInt(), anyInt());

			AvailableColor availableColorOfExteriorColor1 = availableColors.get(0);
			AvailableColor availableColorOfInteriorColor1 = availableColors.get(3);
			softly.assertThat(availableColorOfExteriorColor1.getAdoptionRateTwenty()).isEqualTo(0.0);
			softly.assertThat(availableColorOfInteriorColor1.getAdoptionRateTwenty()).isEqualTo(0.0);

			// when
			adoptionRateScheduler.updateAdoptionRateOfColors();

			// then
			softly.assertThat(availableColorOfExteriorColor1.getAdoptionRateTwenty()).isEqualTo(60.0);
			softly.assertThat(availableColorOfInteriorColor1.getAdoptionRateTwenty()).isEqualTo(30.0);
		}
	}

	@Nested
	@DisplayName("옵션 채택률 테스트")
	class OptionAdoptionRate {

		@Test
		@DisplayName("옵션의 채택률을 업데이트한다.")
		void updateAdoptionRateOfOptions() {
			// given
			doReturn(1L).when(purchasedOptionCountDto).getModelId();
			doReturn(1L).when(purchasedOptionCountDto).getOptionId();
			doReturn(3).when(purchasedOptionCountDto).getCount();
			purchasedOptionCountDtoList.add(purchasedOptionCountDto);

			doReturn(purchasedOptionCountDtoList).when(additionalOptionInfoRepository).countPurchasedOption();
			doReturn(List.of(4L)).when(modelRepository).countPurchasedModel();

			AvailableOption availableOption = AvailableOption.builder()
				.baseOptionInfo(기본옵션X)
				.model(추가옵션가지는_모델)
				.build();
			softly.assertThat(availableOption.getAdoptionRateAll()).isEqualTo(100.0);
			doReturn(availableOption).when(availableOptionRepository)
				.findByModelIdAndAdditionalOptionId(anyLong(), anyLong());

			// when
			adoptionRateScheduler.updateAdoptionRateOfOptions();

			// then
			softly.assertThat(availableOption.getAdoptionRateAll()).isEqualTo((double)3 * 100 / 4);
		}
	}
}
