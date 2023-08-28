package com.softeer.caart.domain.recommendation.lifestyle.service;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.color.entity.AgeGroup;
import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.color.repository.AvailableColorRepository;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.recommendation.carmaster.repository.RecommendedOptionRepository;
import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.ReasonDto;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.RecommendationResponse;
import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.feign.OpenAIFeign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class LifeStyleService {

	private final ModelRepository modelRepository;
	private final AdditionalOptionInfoRepository optionInfoRepository;
	private final RecommendedOptionRepository recommendedOptionRepository;
	private final AvailableColorRepository availableColorRepository;
	private final OpenAIFeign openAIFeign;

	public RecommendationResponse getRecommendationByLifestyle(RecommendationRequest request) throws
		ExecutionException,
		InterruptedException {
		// 모델 추천
		Model model = getMostRecommendedModel(request);
		// 옵션 추천
		List<RecommendedOptionDto> recommendedOptionDtoList = getMostRecommendedOptionDtoList(request, model);
		// 색상 추천
		AgeGroup ageGroup = AgeGroup.valueOf(request.getAge().name());
		List<AvailableColor> recommendedColors = getRecommendedColors(model.getTrim().getId(), ageGroup);
		return RecommendationResponse.of(model, recommendedColors, recommendedOptionDtoList, ageGroup);
	}

	private Model getMostRecommendedModel(RecommendationRequest request) {
		return modelRepository.findMostRecommendedModelByCondition(request.getExperience(), request.getFamily(),
				request.getPurpose(), request.getValue(), request.getMinBudget(), request.getMaxBudget())
			.orElseThrow(() -> new ModelNotFoundException(ResultCode.INVALID_SURVEY));
	}

	private List<RecommendedOptionDto> getMostRecommendedOptionDtoList(RecommendationRequest request,
		Model model) {
		List<AdditionalOptionInfo> twoOptions = optionInfoRepository.findMostRecommendedOptionByCondition(
			request.getExperience(), request.getFamily(), request.getPurpose(), request.getValue(),
			request.getMinBudget(), request.getMaxBudget(), model.getId());
		validateRecommendedOptionCount(twoOptions.size());

		return createRecommendedOptionBasedOnSummary(request, twoOptions);
	}

	private List<RecommendedOptionDto> createRecommendedOptionBasedOnSummary(
		RecommendationRequest request, List<AdditionalOptionInfo> twoOptions) {
		ExecutorService executorService = Executors.newWorkStealingPool();

		// call async
		List<CompletableFuture<ReasonDto>> reasonFutures = twoOptions.stream()
			.map(option -> CompletableFuture.supplyAsync(
				() -> generateReasonByGPTModel(request, option), executorService))
			.collect(Collectors.toList());

		// join and add dto list
		List<RecommendedOptionDto> recommendedOptionDtoList = new ArrayList<>();
		joinAndAddRecommendedOptionDto(0, recommendedOptionDtoList, reasonFutures, twoOptions);
		joinAndAddRecommendedOptionDto(1, recommendedOptionDtoList, reasonFutures, twoOptions);

		return recommendedOptionDtoList;
	}

	private void joinAndAddRecommendedOptionDto(int idx, List<RecommendedOptionDto> dtoList,
		List<CompletableFuture<ReasonDto>> reasonFutures, List<AdditionalOptionInfo> options) {
		ReasonDto reason = reasonFutures.get(idx).join();
		dtoList.add(RecommendedOptionDto.of(options.get(idx), reason.getBody()));
	}

	private void validateRecommendedOptionCount(int optionSize) {
		if (optionSize != 2) {
			throw new InvalidOptionException(ResultCode.INVALID_RECOMMENDED_OPTION_SIZE);
		}
	}

	private ReasonDto generateReasonByGPTModel(RecommendationRequest request, AdditionalOptionInfo option) {
		List<String> reasons = recommendedOptionRepository.findRecommendReasonsByCondition(
			request.getExperience(), request.getFamily(), request.getPurpose(), request.getValue(), option.getId());
		return openAIFeign.summaryReasons(reasons);
	}

	public List<AvailableColor> getRecommendedColors(Long trimId, AgeGroup ageGroup) {
		return Stream.of(true, false)
			.map(isExterior -> findRecommendedColorByAgeGroup(trimId, ageGroup, isExterior))
			.collect(Collectors.toList());
	}

	private AvailableColor findRecommendedColorByAgeGroup(Long trimId, AgeGroup ageGroup, boolean isExterior) {
		AvailableColor recommendedColor;
		switch (ageGroup) {
			case TWENTY:
				recommendedColor = availableColorRepository.findMostAdoptedColorForTwenty(trimId, isExterior);
				break;
			case THIRTY:
				recommendedColor = availableColorRepository.findMostAdoptedColorForThirty(trimId, isExterior);
				break;
			case FORTY:
				recommendedColor = availableColorRepository.findMostAdoptedColorForForty(trimId, isExterior);
				break;
			case FIFTY_OR_ABOVE:
				recommendedColor = availableColorRepository.findMostAdoptedColorForFiftyOrAbove(trimId, isExterior);
				break;
			default:
				recommendedColor = availableColorRepository.findMostAdoptedColorForAll(trimId, isExterior);
		}
		return recommendedColor;
	}
}
