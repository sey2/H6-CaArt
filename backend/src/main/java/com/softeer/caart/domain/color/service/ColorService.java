package com.softeer.caart.domain.color.service;

import static com.softeer.caart.domain.color.dto.ColorDto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.softeer.caart.domain.color.dto.ColorResponse;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.entity.Color;
import com.softeer.caart.domain.color.exception.TrimNotFoundException;
import com.softeer.caart.domain.color.repository.ColorRepository;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.domain.trim.repository.TrimRepository;
import com.softeer.caart.global.ResultCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorService {

	private final ColorRepository colorRepository;
	private final TrimRepository trimRepository;

	public ColorResponse getColors(Long currentTrimId) {
		List<Color> colors = colorRepository.findColorsByTrimId(currentTrimId);
		if (colors.isEmpty()) {
			throw new TrimNotFoundException(ResultCode.TRIM_NOT_FOUND);
		}
		Map<Trim, List<AvailableColor>> otherTrimColors = getOtherTrimColors(currentTrimId);

		// 현재 선택한 트림의 색상들
		List<ExteriorColorDto> exteriorColors = new ArrayList<>();
		List<InteriorColorDto> interiorColors = new ArrayList<>();
		initColors(colors, exteriorColors, interiorColors);

		// 다른 트림의 색상들
		List<OtherTrimColorDto> otherTrimExteriorColors = new ArrayList<>();
		List<OtherTrimColorDto> otherTrimInteriorColors = new ArrayList<>();
		initOtherTrimColors(colors, otherTrimColors, otherTrimExteriorColors, otherTrimInteriorColors);

		// 응답 생성
		return ColorResponse.of(exteriorColors, otherTrimExteriorColors, interiorColors, otherTrimInteriorColors);
	}

	private Map<Trim, List<AvailableColor>> getOtherTrimColors(Long excludedTrimId) {
		return trimRepository.findOtherTrimsWithColors(excludedTrimId).stream()
			.collect(Collectors.toMap(
				trim -> trim,
				Trim::getAvailableColors
			));
	}

	private void initColors(List<Color> colors,
		List<ExteriorColorDto> exteriorColors, List<InteriorColorDto> interiorColors) {
		for (Color color : colors) {
			addColor(exteriorColors, interiorColors, color);
		}
	}

	private void addColor(List<ExteriorColorDto> exteriorColors,
		List<InteriorColorDto> interiorColors, Color color) {
		// 외장 색상 추가
		if (color.isExteriorColor()) {
			exteriorColors.add(new ExteriorColorDto(color));
			return;
		}
		// 내장 색상 추가
		interiorColors.add(new InteriorColorDto(color));
	}

	private void initOtherTrimColors(List<Color> colors, Map<Trim, List<AvailableColor>> otherTrimColors,
		List<OtherTrimColorDto> otherTrimExteriorColors, List<OtherTrimColorDto> otherTrimInteriorColors) {
		for (Map.Entry<Trim, List<AvailableColor>> entry : otherTrimColors.entrySet()) {
			Trim trim = entry.getKey();
			List<Color> otherColors = entry.getValue().stream()
				.map(AvailableColor::getColor)
				.filter(color -> !colors.contains(color))
				.collect(Collectors.toList());
			addColorToTrim(trim, otherColors, otherTrimExteriorColors, otherTrimInteriorColors);
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
