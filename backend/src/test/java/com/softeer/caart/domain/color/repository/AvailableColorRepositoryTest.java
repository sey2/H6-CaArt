package com.softeer.caart.domain.color.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AgeGroup;
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
		assertThat(purchasedColorCountDto.getCount()).isEqualTo(2);
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
		assertThat(purchasedColorCountDto.getCount()).isEqualTo(1);
	}
}
