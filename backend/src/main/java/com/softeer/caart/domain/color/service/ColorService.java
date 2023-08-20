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

	public ColorResponse getColors(Long trimId) {
		List<Color> colorsOfCurrentTrim = colorRepository.findColorsOfCurrentTrim(trimId);
		if (colorsOfCurrentTrim.isEmpty()) {
			throw new TrimNotFoundException(ResultCode.TRIM_NOT_FOUND);
		}
		Map<Trim, List<AvailableColor>> colorsOfOtherTrims = getColorsOfOtherTrims(trimId);

		// 현재 선택한 트림의 색상들
		List<ExteriorColorDto> exteriorColorDtoList = new ArrayList<>();
		List<InteriorColorDto> interiorColorDtoList = new ArrayList<>();
		initColorDtoListOfCurrentTrim(colorsOfCurrentTrim, exteriorColorDtoList, interiorColorDtoList);

		// 다른 트림의 색상들
		List<OtherTrimColorDto> otherTrimExteriorColorDtoList = new ArrayList<>();
		List<OtherTrimColorDto> otherTrimInteriorColorDtoList = new ArrayList<>();
		initColorDtoListOfOtherTrims(colorsOfCurrentTrim, colorsOfOtherTrims, otherTrimExteriorColorDtoList,
			otherTrimInteriorColorDtoList);

		// 응답 생성
		return ColorResponse.of(exteriorColorDtoList, otherTrimExteriorColorDtoList,
			interiorColorDtoList, otherTrimInteriorColorDtoList);
	}

	private Map<Trim, List<AvailableColor>> getColorsOfOtherTrims(Long trimId) {
		return trimRepository.findOtherTrimsWithColors(trimId).stream()
			.collect(Collectors.toMap(
				trim -> trim,
				Trim::getAvailableColors
			));
	}

	private void initColorDtoListOfCurrentTrim(List<Color> availableColorsOfCurrentTrim,
		List<ExteriorColorDto> exteriorColorDtoList,
		List<InteriorColorDto> interiorColorDtoList) {
		for (Color color : availableColorsOfCurrentTrim) {
			addColorDto(exteriorColorDtoList, interiorColorDtoList, color);
		}
	}

	private void addColorDto(List<ExteriorColorDto> exteriorColorDtoList,
		List<InteriorColorDto> interiorColorDtoList,
		Color color) {
		// 외장 색상
		if (color.isExteriorColor()) {
			exteriorColorDtoList.add(new ExteriorColorDto(color));
			return;
		}
		// 내장 색상
		interiorColorDtoList.add(new InteriorColorDto(color));
	}

	private void initColorDtoListOfOtherTrims(List<Color> colorsOfCurrentTrim,
		Map<Trim, List<AvailableColor>> colorsOfOtherTrims,
		List<OtherTrimColorDto> otherTrimExteriorColorDtoList,
		List<OtherTrimColorDto> otherTrimInteriorColorDtoList) {
		for (Map.Entry<Trim, List<AvailableColor>> entry : colorsOfOtherTrims.entrySet()) {
			Trim trim = entry.getKey();
			OtherTrimColorDto otherTrimExteriorColorDto = new OtherTrimColorDto(trim);
			OtherTrimColorDto otherTrimInteriorColorDto = new OtherTrimColorDto(trim);

			for (AvailableColor availableColor : entry.getValue()) {
				Color color = availableColor.getColor();
				addColor(colorsOfCurrentTrim, otherTrimExteriorColorDto, otherTrimInteriorColorDto, color);
			}
			addOtherTrimColorDto(otherTrimExteriorColorDtoList, otherTrimExteriorColorDto);
			addOtherTrimColorDto(otherTrimInteriorColorDtoList, otherTrimInteriorColorDto);
		}
	}

	private void addColor(List<Color> colorsOfCurrentTrim,
		OtherTrimColorDto otherTrimExteriorColorDto,
		OtherTrimColorDto otherTrimInteriorColorDto,
		Color color) {
		// 현재 트림에서도 선택 가능한 색상이면 패스
		if (colorsOfCurrentTrim.contains(color)) {
			return;
		}
		// 외장 색상
		if (color.isExteriorColor()) {
			otherTrimExteriorColorDto.addColor(color);
			return;
		}
		// 내장 색상
		otherTrimInteriorColorDto.addColor(color);
	}

	private void addOtherTrimColorDto(List<OtherTrimColorDto> otherTrimColorDtoList,
		OtherTrimColorDto otherTrimColorDto) {
		if (otherTrimColorDto.getColors().isEmpty()) {
			return;
		}
		otherTrimColorDtoList.add(otherTrimColorDto);
	}
}
