package com.softeer.caart.domain.recommendation.carmaster.service;

import static com.softeer.caart.global.ResultCode.*;
import static org.springframework.data.domain.Sort.Direction.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.composition.dto.response.BodyTypeSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.CarEngineSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.CompositionSummaryResponse;
import com.softeer.caart.domain.composition.dto.response.WheelDriveSummaryResponse;
import com.softeer.caart.domain.composition.entity.BodyType;
import com.softeer.caart.domain.composition.entity.CarEngine;
import com.softeer.caart.domain.composition.entity.WheelDrive;
import com.softeer.caart.domain.composition.exception.BodyTypeNotFoundException;
import com.softeer.caart.domain.composition.exception.EngineNotFoundException;
import com.softeer.caart.domain.composition.exception.WheelDriveNotFoundException;
import com.softeer.caart.domain.composition.repository.BodyTypeRepository;
import com.softeer.caart.domain.composition.repository.CarEngineRepository;
import com.softeer.caart.domain.composition.repository.WheelDriveRepository;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.recommendation.carmaster.dto.CreateSurveyRequest;
import com.softeer.caart.domain.recommendation.carmaster.dto.SurveyResponse;
import com.softeer.caart.domain.recommendation.carmaster.entity.CarMasterSurvey;
import com.softeer.caart.domain.recommendation.carmaster.entity.RecommendedOption;
import com.softeer.caart.domain.recommendation.carmaster.repository.CarMasterSurveyRepository;
import com.softeer.caart.domain.recommendation.carmaster.repository.RecommendedOptionRepository;
import com.softeer.caart.domain.trim.dto.response.TrimSummaryResponse;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.domain.trim.exception.TrimNotFoundException;
import com.softeer.caart.domain.trim.repository.TrimRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CarMasterService {
	private final TrimRepository trimRepository;
	private final CarEngineRepository carEngineRepository;
	private final BodyTypeRepository bodyTypeRepository;
	private final WheelDriveRepository wheelDriveRepository;
	private final CarMasterSurveyRepository carMasterSurveyRepository;
	private final RecommendedOptionRepository recommendedOptionRepository;
	private final AdditionalOptionInfoRepository additionalOptionInfoRepository;

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

	@Transactional
	public void saveSurvey(CreateSurveyRequest dto) {
		// 카마스터 설문 데이터 저장
		CarMasterSurvey createdSurvey = createSurvey(dto);
		CarMasterSurvey survey = carMasterSurveyRepository.save(createdSurvey);

		// 카마스터가 추천한 옵션 2개 저장
		RecommendedOption createdRecommendedOption1 = createRecommendedOption(dto.getAdditionalOptionId1(),
			dto.getReason1(), survey);
		RecommendedOption createdRecommendedOption2 = createRecommendedOption(dto.getAdditionalOptionId2(),
			dto.getReason2(), survey);
		recommendedOptionRepository.save(createdRecommendedOption1);
		recommendedOptionRepository.save(createdRecommendedOption2);
	}

	private CarMasterSurvey createSurvey(CreateSurveyRequest dto) {
		final Trim trim = trimRepository.findById(dto.getTrimId())
			.orElseThrow(() -> new TrimNotFoundException(TRIM_NOT_FOUND));
		final CarEngine engine = carEngineRepository.findById(dto.getEngineId())
			.orElseThrow(() -> new EngineNotFoundException(ENGINE_NOT_FOUND));
		final BodyType bodyType = bodyTypeRepository.findById(dto.getBodyTypeId())
			.orElseThrow(() -> new BodyTypeNotFoundException(BODY_TYPE_NOT_FOUND));
		final WheelDrive wd = wheelDriveRepository.findById(dto.getWdId())
			.orElseThrow(() -> new WheelDriveNotFoundException(WHEEL_DRIVE_NOT_FOUND));
		return dto.toCarMasterSurveyEntity(trim, engine, bodyType, wd);
	}

	private RecommendedOption createRecommendedOption(Long optionId, String reason, CarMasterSurvey survey) {
		AdditionalOptionInfo option = additionalOptionInfoRepository.findById(optionId)
			.orElseThrow(() -> new OptionNotFoundException(OPTION_NOT_FOUND));
		return RecommendedOption.builder()
			.reason(reason)
			.option(option)
			.survey(survey)
			.build();
	}
}
