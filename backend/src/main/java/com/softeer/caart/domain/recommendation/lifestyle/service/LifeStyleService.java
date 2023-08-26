package com.softeer.caart.domain.recommendation.lifestyle.service;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.RecommendationResponse;
import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.feign.OpenAiFeign;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LifeStyleService {

	private final ModelRepository modelRepository;
	private final AdditionalOptionInfoRepository optionInfoRepository;
	private final RecommendedOptionRepository recommendedOptionRepository;
	private final AvailableColorRepository availableColorRepository;
	private final OpenAiFeign openAiFeign;

	// TODO : write basic test codes
	public RecommendationResponse getRecommendationByLifestyle(RecommendationRequest request) {
		// 모델 추천
		Model model = getMostRecommendedModel(request);
		// 옵션 추천
		List<AdditionalOptionInfo> twoOptions = getMostRecommendedTwoOptions(request, model);
		List<RecommendedOptionDto> recommendedOptionDtoList = twoOptions.stream()
			.map(optionInfo -> RecommendedOptionDto.of(optionInfo,
				generateReasonByChatGPT(request, optionInfo)))
			.collect(Collectors.toList());
		// 색상 추천
		AgeGroup ageGroup = AgeGroup.valueOf(request.getAge().name());
		List<AvailableColor> recommendedColors = getRecommendedColors(model.getTrim().getId(), ageGroup);
		return RecommendationResponse.of(model, recommendedColors, recommendedOptionDtoList, ageGroup);
	}

	private Model getMostRecommendedModel(RecommendationRequest request) {
		return modelRepository.findMostRecommendedModelByCondition(request.getExperience(), request.getFamily(),
				request.getPurpose(), request.getValue(), request.getMinBudget(), request.getMaxBudget())
			.orElseThrow(() -> new ModelNotFoundException(ResultCode.SURVEY_NOT_FOUND));
	}

	private List<AdditionalOptionInfo> getMostRecommendedTwoOptions(RecommendationRequest request, Model model) {
		List<AdditionalOptionInfo> twoOptions = optionInfoRepository.findMostRecommendedOptionByCondition(
			request.getExperience(), request.getFamily(), request.getPurpose(), request.getValue(),
			request.getMinBudget(), request.getMaxBudget(), model.getId());
		validateRecommendedOptionCount(twoOptions.size());
		return twoOptions;
	}

	private void validateRecommendedOptionCount(int optionSize) {
		if (optionSize != 2) {
			throw new InvalidOptionException(ResultCode.INVALID_RECOMMENDED_OPTION_SIZE);
		}
	}

	/**
	 * OpenAI API를 이용해 GPT 모델로 추천 사유를 요약한다.
	 * <br>
	 * Request 예시:<br>
	 * 	 POST https://dxts501dik.execute-api.ap-northeast-2.amazonaws.com/stage/generate-reason
	 * 	 <br>
	 *   {
	 *      "reasons" : ["운전 중에도 무릎의 따뜻함을 항상 느낄 수 있게 해줍니다.",
	 *                   "무릎을 따뜻하게 해주면서 건강까지 지켜주는 놀라운 옵션!",
	 *                   "겨울 운전 중 저체온증을 예방하는 데 도움을 줍니다.",
	 *                   "냉기로부터 무릎을 보호하는 가장 현대적인 방법입니다.",
	 *                   "겨울의 까칠한 무릎 문제를 해결하는 스마트한 방법!"]
	 *   }
	 * <br>
	 * Response 예시:<br>
	 *   "블랙톤 휠은 운전 중에도 무릎의 따뜻함을 느낄 수 있도록 해요."
	 */
	private String generateReasonByChatGPT(RecommendationRequest request, AdditionalOptionInfo option) {
		List<String> reasons = recommendedOptionRepository.findRecommendReasonsByCondition(
			request.getExperience(), request.getFamily(), request.getPurpose(), request.getValue(), option.getId());
		return openAiFeign.getRecommendationMessage(reasons);
	}

	public List<AvailableColor> getRecommendedColors(Long trimId, AgeGroup ageGroup) {
		List<AvailableColor> recommendedColors = new ArrayList<>();
		AvailableColor recommendedExteriorColor;
		AvailableColor recommendedInteriorColor;
		switch (ageGroup) {
			case TWENTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForTwenty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForTwenty(trimId, false);
				break;
			case THIRTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForThirty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForThirty(trimId, false);
				break;
			case FORTY:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForForty(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForForty(trimId, false);
				break;
			case FIFTY_OR_ABOVE:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForFiftyOrAbove(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForFiftyOrAbove(trimId, false);
				break;
			default:
				recommendedExteriorColor = availableColorRepository.findMostAdoptedColorForAll(trimId, true);
				recommendedInteriorColor = availableColorRepository.findMostAdoptedColorForAll(trimId, false);
				break;
		}
		recommendedColors.add(recommendedExteriorColor);
		recommendedColors.add(recommendedInteriorColor);
		return recommendedColors;
	}
}
