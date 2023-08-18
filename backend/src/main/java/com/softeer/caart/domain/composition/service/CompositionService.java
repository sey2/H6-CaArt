package com.softeer.caart.domain.composition.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.composition.dto.response.BodyTypeResponse;
import com.softeer.caart.domain.composition.dto.response.CarEngineResponse;
import com.softeer.caart.domain.composition.dto.response.CompositionResponse;
import com.softeer.caart.domain.composition.dto.response.WheelDriveResponse;
import com.softeer.caart.domain.composition.repository.BodyTypeRepository;
import com.softeer.caart.domain.composition.repository.CarEngineRepository;
import com.softeer.caart.domain.composition.repository.WheelDriveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompositionService {
	private final CarEngineRepository carEngineRepository;
	private final BodyTypeRepository bodyTypeRepository;
	private final WheelDriveRepository wheelDriveRepository;

	public CompositionResponse getCompositionInfos() {
		List<CarEngineResponse> carEngines = getCarEngineResponses();
		List<BodyTypeResponse> bodyTypes = getBodyTypeResponses();
		List<WheelDriveResponse> wheelDrives = getWheelDriveResponses();

		return CompositionResponse.from(carEngines, bodyTypes, wheelDrives);
	}

	private List<CarEngineResponse> getCarEngineResponses() {
		return carEngineRepository.findAll().stream()
			.map(CarEngineResponse::from)
			.collect(Collectors.toList());
	}

	private List<BodyTypeResponse> getBodyTypeResponses() {
		return bodyTypeRepository.findAll().stream()
			.map(BodyTypeResponse::from)
			.collect(Collectors.toList());
	}

	private List<WheelDriveResponse> getWheelDriveResponses() {
		return wheelDriveRepository.findAll().stream()
			.map(WheelDriveResponse::from)
			.collect(Collectors.toList());
	}
}
