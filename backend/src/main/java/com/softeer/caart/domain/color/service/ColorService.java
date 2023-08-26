package com.softeer.caart.domain.color.service;

import static com.softeer.caart.domain.color.dto.ColorDto.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.color.dto.ColorResponse;
import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.domain.trim.exception.TrimNotFoundException;
import com.softeer.caart.domain.trim.repository.TrimRepository;
import com.softeer.caart.global.ResultCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ColorService {

	private final TrimRepository trimRepository;

	public ColorResponse getColors(Long currentTrimId, AgeGroup ageGroup) {
		Map<Trim, List<AvailableColor>> trimAvailableColorMap = getTrimColorMap();
		List<AvailableColor> availableColors = getCurrentTrimColors(trimAvailableColorMap, currentTrimId);

		// 현재 선택한 트림의 색상들
		List<ExteriorColorDto> exteriorColors = new ArrayList<>();
		List<InteriorColorDto> interiorColors = new ArrayList<>();
		initColors(availableColors, exteriorColors, interiorColors, ageGroup);
		// 채택률 내림차순으로 정렬
		exteriorColors.sort(Comparator.comparingDouble(ExteriorColorDto::getAdoptionRate).reversed());
		interiorColors.sort(Comparator.comparingDouble(InteriorColorDto::getAdoptionRate).reversed());

		// 다른 트림의 색상들
		List<OtherTrimColorDto> otherTrimExteriorColors = new ArrayList<>();
		List<OtherTrimColorDto> otherTrimInteriorColors = new ArrayList<>();
		initOtherTrimColors(availableColors, trimAvailableColorMap, otherTrimExteriorColors, otherTrimInteriorColors);

		// 응답 생성
		return ColorResponse.of(currentTrimId, exteriorColors, otherTrimExteriorColors,
			interiorColors, otherTrimInteriorColors);
	}

	private Map<Trim, List<AvailableColor>> getTrimColorMap() {
		return trimRepository.findTrimsWithColors().stream()
			.collect(Collectors.toMap(
				trim -> trim,
				Trim::getAvailableColors
			));
	}

	private List<AvailableColor> getCurrentTrimColors(Map<Trim, List<AvailableColor>> trimColorMap,
		Long currentTrimId) {
		Optional<Trim> currentTrim = trimColorMap.keySet().stream()
			.filter(trim -> trim.getId().equals(currentTrimId))
			.findAny();
		if (currentTrim.isEmpty()) {
			throw new TrimNotFoundException(ResultCode.TRIM_NOT_FOUND);
		}
		return trimColorMap.get(currentTrim.get());
	}

	private void initColors(List<AvailableColor> availableColors,
		List<ExteriorColorDto> exteriorColors, List<InteriorColorDto> interiorColors, AgeGroup ageGroup) {
		for (AvailableColor availableColor : availableColors) {
			Color color = availableColor.getColor();
			double adoptionRate = availableColor.getAdoptionRate(ageGroup);
			addColor(exteriorColors, interiorColors, color, adoptionRate);
		}
	}

	private void addColor(List<ExteriorColorDto> exteriorColors, List<InteriorColorDto> interiorColors,
		Color color, double adoptionRate) {
		// 외장 색상 추가
		if (color.isExteriorColor()) {
			exteriorColors.add(new ExteriorColorDto(color, adoptionRate));
			return;
		}
		// 내장 색상 추가
		interiorColors.add(new InteriorColorDto(color, adoptionRate));
	}

	private void initOtherTrimColors(List<AvailableColor> availableColors,
		Map<Trim, List<AvailableColor>> trimAvailableColorMap,
		List<OtherTrimColorDto> otherTrimExteriorColors,
		List<OtherTrimColorDto> otherTrimInteriorColors) {

		List<Color> colors = availableColors.stream().map(AvailableColor::getColor).collect(Collectors.toList());
		for (Map.Entry<Trim, List<AvailableColor>> entry : trimAvailableColorMap.entrySet()) {
			Trim trim = entry.getKey();
			List<Color> otherColors = entry.getValue().stream()
				.map(AvailableColor::getColor)
				.filter(color -> !colors.contains(color))
				.collect(Collectors.toList());
			if (!otherColors.isEmpty()) {
				addColorToTrim(trim, otherColors, otherTrimExteriorColors, otherTrimInteriorColors);
			}
		}
	}

	private void addColorToTrim(Trim trim, List<Color> otherColors,
		List<OtherTrimColorDto> otherTrimExteriorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		for (Color color : otherColors) {
			// 외장 색상
			if (color.isExteriorColor()) {
				otherTrimExteriorColors.add(new OtherTrimColorDto(color, trim));
				continue;
			}
			// 내장 색상
			otherTrimInteriorColors.add(new OtherTrimColorDto(color, trim));
		}
	}
}
