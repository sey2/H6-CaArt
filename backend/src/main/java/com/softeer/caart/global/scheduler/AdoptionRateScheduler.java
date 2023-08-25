package com.softeer.caart.global.scheduler;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.repository.AvailableColorRepository;
import com.softeer.caart.domain.model.entity.AvailableOption;
import com.softeer.caart.domain.model.repository.AvailableOptionRepository;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.PurchasedOptionCountDto;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdoptionRateScheduler {

	private final AvailableColorRepository availableColorRepository;
	private final AdditionalOptionInfoRepository additionalOptionInfoRepository;
	private final ModelRepository modelRepository;
	private final AvailableOptionRepository availableOptionRepository;

	// @Scheduled(fixedDelay = 1000000000)
	@Transactional
	@Scheduled(cron = "0 0 3 * * ?", zone = "Asia/Seoul")
	public void updateAdoptionRateOfColors() {
		MultiValueMap<Trim, AvailableColor> trimAvailableColorMap = getTrimAvailableColorMap();
		// 각 트림에 대해
		for (Map.Entry<Trim, List<AvailableColor>> entry : trimAvailableColorMap.entrySet()) {
			Trim trim = entry.getKey();
			List<AvailableColor> availableColors = entry.getValue();
			// 연령대에 따른
			for (AgeGroup ageGroup : AgeGroup.values()) {
				// 외장 색상의 채택률 계산 및 업데이트
				List<PurchasedColorCountDto> purchasedExteriorColorCountDtoList = availableColorRepository
					.countPurchasedExteriorColorByAgeGroup(trim.getId(), ageGroup.getBeginning(), ageGroup.getEnd());
				updateAdoptionRateOfColor(availableColors, ageGroup, purchasedExteriorColorCountDtoList);
				// 내장 색상의 채택률 계산 및 업데이트
				List<PurchasedColorCountDto> purchasedInteriorColorCountDtoList = availableColorRepository
					.countPurchasedInteriorColorByAgeGroup(trim.getId(), ageGroup.getBeginning(), ageGroup.getEnd());
				updateAdoptionRateOfColor(availableColors, ageGroup, purchasedInteriorColorCountDtoList);
			}
		}
	}

	public MultiValueMap<Trim, AvailableColor> getTrimAvailableColorMap() {
		MultiValueMap<Trim, AvailableColor> trimAvailableColorMap = new LinkedMultiValueMap<>();
		availableColorRepository.findAll()
			.forEach(availableColor -> trimAvailableColorMap.add(availableColor.getTrim(), availableColor));
		return trimAvailableColorMap;
	}

	private void updateAdoptionRateOfColor(List<AvailableColor> availableColors, AgeGroup ageGroup,
		List<PurchasedColorCountDto> purchasedColorCountDtoList) {
		int totalCount = purchasedColorCountDtoList.stream().mapToInt(PurchasedColorCountDto::getCount).sum();
		for (PurchasedColorCountDto purchasedColorCountDto : purchasedColorCountDtoList) {
			AvailableColor availableColor = getAvailableColorWithColorId(availableColors,
				purchasedColorCountDto.getColorId());
			double adoptionRate = (double)purchasedColorCountDto.getCount() * 100 / totalCount;
			// 채택률 업데이트
			availableColor.updateAdoptionRate(ageGroup, adoptionRate);
		}
	}

	private AvailableColor getAvailableColorWithColorId(List<AvailableColor> availableColors, Long colorId) {
		Optional<AvailableColor> availableColor = availableColors.stream()
			.filter(avc -> avc.getColor().getId().equals(colorId))
			.findAny();
		if (availableColor.isEmpty()) {
			throw new BusinessException(ResultCode.INTERNAL_SERVER_ERROR);
		}
		return availableColor.get();
	}

	// @Scheduled(fixedDelay = 1000000000)
	@Transactional
	@Scheduled(cron = "0 5 3 * * ?", zone = "Asia/Seoul")
	public void updateAdoptionRateOfOptions() {
		List<PurchasedOptionCountDto> purchasedOptionCountDtoList = additionalOptionInfoRepository.countPurchasedOption();
		List<Long> purchasedModelCounts = modelRepository.countPurchasedModel();

		for (PurchasedOptionCountDto purchasedOptionCountDto : purchasedOptionCountDtoList) {
			Long modelId = purchasedOptionCountDto.getModelId();
			Long optionId = purchasedOptionCountDto.getOptionId();
			if (optionId == null) {
				continue;
			}
			int count = purchasedOptionCountDto.getCount();
			// 모델 아이디와 옵션 아이디로 AvailableOption을 조회
			AvailableOption availableOption = availableOptionRepository.findByModelIdAndAdditionalOptionId(
				modelId, optionId);
			// 채택률 계산: 해당 모델-옵션 구매 횟수 / 해당 모델 구매 횟수
			double adoptionRate = (double)count * 100 / purchasedModelCounts.get(modelId.intValue() - 1);
			// 채택률 업데이트
			availableOption.updateAdoptionRate(adoptionRate);
		}
	}
}
