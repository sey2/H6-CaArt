package com.softeer.caart.domain.recommendation.carmaster.service;

import static org.springframework.data.domain.Sort.Direction.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softeer.caart.domain.composition.dto.response.BodyTypeSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.CarEngineSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.CompositionSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.WheelDriveSummaryResponse;
import com.softeer.caart.domain.composition.repository.BodyTypeRepository;
import com.softeer.caart.domain.composition.repository.CarEngineRepository;
import com.softeer.caart.domain.composition.repository.WheelDriveRepository;
import com.softeer.caart.domain.recommendation.carmaster.dto.SurveyResponse;
import com.softeer.caart.domain.trim.dto.response.TrimSummaryResponse;
import com.softeer.caart.domain.trim.repository.TrimRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarMasterService {
	private final TrimRepository trimRepository;
	private final CarEngineRepository carEngineRepository;
	private final BodyTypeRepository bodyTypeRepository;
	private final WheelDriveRepository wheelDriveRepository;

	public SurveyResponse getSurvey() {
		List<TrimSummaryResponse> trims = getTrimSummaries();
		CompositionSummaryResponse composition = getCompositionSummaryResponse();

		return SurveyResponse.of(trims, composition);
	}

	private List<TrimSummaryResponse> getTrimSummaries() {
		return trimRepository.findAll(Sort.by(ASC, "price")).stream()
			.map(TrimSummaryResponse::from)
			.collect(Collectors.toList());
	}

	private CompositionSummaryResponse getCompositionSummaryResponse() {
		List<CarEngineSummaryResponse> engines = getCarEngines();
		List<BodyTypeSummaryResponse> bodyTypes = getBodyTypes();
		List<WheelDriveSummaryResponse> wheelDrives = getWheelDrives();
		return CompositionSummaryResponse.of(engines, bodyTypes, wheelDrives);
	}

	private List<CarEngineSummaryResponse> getCarEngines() {
		return carEngineRepository.findAll().stream()
			.map(CarEngineSummaryResponse::from)
			.collect(Collectors.toList());
	}

	private List<BodyTypeSummaryResponse> getBodyTypes() {
		return bodyTypeRepository.findAll().stream()
			.map(BodyTypeSummaryResponse::from)
			.collect(Collectors.toList());
	}

	private List<WheelDriveSummaryResponse> getWheelDrives() {
		return wheelDriveRepository.findAll().stream()
			.map(WheelDriveSummaryResponse::from)
			.collect(Collectors.toList());
	}
}
