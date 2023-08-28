package com.softeer.caart.domain.color.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.common.RepositoryTest;

class AvailableColorRepositoryTest extends RepositoryTest {

	@Autowired
	AvailableColorRepository availableColorRepository;

	@Test
	@DisplayName("1번 트림의 20대 구매자들에게 각 외장 색상이 구매된 횟수를 조회한다.")
	void countPurchasedExteriorColorByAgeGroup() {
		assertThat(availableColorRepository).isNotNull();
		// given
		Long trimId = 1L;
		AgeGroup twenty = AgeGroup.TWENTY;

		// when
		List<PurchasedColorCountDto> purchasedColorCountDtoList = availableColorRepository.countPurchasedExteriorColorByAgeGroup(
			trimId, twenty.getBeginning(), twenty.getEnd());

		// then
		assertThat(purchasedColorCountDtoList).hasSize(2);
		PurchasedColorCountDto purchasedColorCountDto = purchasedColorCountDtoList.get(0);
		assertThat(purchasedColorCountDto.getColorId()).isEqualTo(1L);
		assertThat(purchasedColorCountDto.getCount()).isEqualTo(4);
	}

	@Test
	@DisplayName("1번 트림의 20대 구매자들에게 각 내장 색상이 구매된 횟수를 조회한다.")
	void countPurchasedInteriorColorByAgeGroup() {
		assertThat(availableColorRepository).isNotNull();
		// given
		Long trimId = 1L;
		AgeGroup twenty = AgeGroup.TWENTY;

		// when
		List<PurchasedColorCountDto> purchasedColorCountDtoList = availableColorRepository.countPurchasedInteriorColorByAgeGroup(
			trimId, twenty.getBeginning(), twenty.getEnd());

		// then
		assertThat(purchasedColorCountDtoList).hasSize(2);
		PurchasedColorCountDto purchasedColorCountDto = purchasedColorCountDtoList.get(0);
		assertThat(purchasedColorCountDto.getColorId()).isEqualTo(3L);
		assertThat(purchasedColorCountDto.getCount()).isEqualTo(3);
	}

	@Test
	@DisplayName("20대에서 가장 채택률이 높은 색상을 조회한다.")
	void findMostAdoptedColorForTwenty() {
		// given
		Long trimId = 1L;

		// when
		AvailableColor mostAdoptedExteriorColorForTwenty = availableColorRepository.findMostAdoptedColorForTwenty(
			trimId, true);
		AvailableColor mostAdoptedInteriorColorForTwenty = availableColorRepository.findMostAdoptedColorForTwenty(
			trimId, false);

		// then
		softly.assertThat(mostAdoptedExteriorColorForTwenty).isNotNull();
		softly.assertThat(mostAdoptedExteriorColorForTwenty.getId()).isEqualTo(1L);
		softly.assertThat(mostAdoptedInteriorColorForTwenty).isNotNull();
		softly.assertThat(mostAdoptedInteriorColorForTwenty.getId()).isEqualTo(3L);
	}

	@Test
	@DisplayName("30대에서 가장 채택률이 높은 색상을 조회한다.")
	void findMostAdoptedColorForThirty() {
		// given
		Long trimId = 1L;

		// when
		AvailableColor mostAdoptedExteriorColorForThirty = availableColorRepository.findMostAdoptedColorForThirty(
			trimId, true);
		AvailableColor mostAdoptedInteriorColorForThirty = availableColorRepository.findMostAdoptedColorForThirty(
			trimId, false);

		// then
		softly.assertThat(mostAdoptedExteriorColorForThirty.getId()).isEqualTo(1L);
		softly.assertThat(mostAdoptedExteriorColorForThirty.getAdoptionRateThirty()).isEqualTo(60.0);
		softly.assertThat(mostAdoptedInteriorColorForThirty.getId()).isEqualTo(3L);
	}

	@Test
	@DisplayName("40대에서 가장 채택률이 높은 색상을 조회한다.")
	void findMostAdoptedColorForForty() {
		// given
		Long trimId = 1L;

		// when
		AvailableColor mostAdoptedExteriorColorForForty = availableColorRepository.findMostAdoptedColorForForty(
			trimId, true);
		AvailableColor mostAdoptedInteriorColorForForty = availableColorRepository.findMostAdoptedColorForForty(
			trimId, false);

		// then
		softly.assertThat(mostAdoptedExteriorColorForForty.getId()).isEqualTo(1L);
		softly.assertThat(mostAdoptedInteriorColorForForty.getId()).isEqualTo(4L);
		softly.assertThat(mostAdoptedInteriorColorForForty.getAdoptionRateForty()).isEqualTo(100.0);
	}

	@Test
	@DisplayName("50대 이상에서 가장 채택률이 높은 색상을 조회한다.")
	void findMostAdoptedColorForFiftyOrAbove() {
		// given
		Long trimId = 1L;

		// when
		AvailableColor mostAdoptedExteriorColorForFiftyOrAbove = availableColorRepository
			.findMostAdoptedColorForFiftyOrAbove(trimId, true);
		AvailableColor mostAdoptedInteriorColorForFiftyOrAbove = availableColorRepository
			.findMostAdoptedColorForFiftyOrAbove(trimId, false);

		// then
		softly.assertThat(mostAdoptedExteriorColorForFiftyOrAbove.getId()).isEqualTo(2L);
		softly.assertThat(mostAdoptedExteriorColorForFiftyOrAbove.getAdoptionRateFiftyOrAbove()).isEqualTo(80.0);
		softly.assertThat(mostAdoptedInteriorColorForFiftyOrAbove.getId()).isEqualTo(3L);
	}

	@Test
	@DisplayName("전체 구매자 대상으로 가장 채택률이 높은 색상을 조회한다.")
	void findMostAdoptedColorForAll() {
		// given
		Long trimId = 1L;

		// when
		AvailableColor mostAdoptedExteriorColorForAll = availableColorRepository.findMostAdoptedColorForAll(
			trimId, true);
		AvailableColor mostAdoptedInteriorColorForAll = availableColorRepository.findMostAdoptedColorForAll(
			trimId, false);

		// then
		softly.assertThat(mostAdoptedExteriorColorForAll.getId()).isEqualTo(1L);
		softly.assertThat(mostAdoptedInteriorColorForAll.getId()).isEqualTo(3L);
	}
}
