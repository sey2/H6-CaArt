package com.softeer.caart.domain.recommendation.lifestyle.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LifeStyleService {
	private final ModelRepository modelRepository;
	private final AdditionalOptionInfoRepository optionInfoRepository;
	private final RecommendedOptionRepository recommendedOptionRepository;

	// TODO : write basic test codes
	public RecommendationResponse getRecommendationByLifestyle(RecommendationRequest request) {
		Model model = getMostRecommendedModel(request);
		List<AdditionalOptionInfo> twoOptions = getMostRecommendedTwoOptions(request, model);
		String reason1 = generateReasonByChatGPT(request, twoOptions.get(0));
		String reason2 = generateReasonByChatGPT(request, twoOptions.get(1));
		return RecommendationResponse.of(model, twoOptions, reason1, reason2);
	}

	private Model getMostRecommendedModel(RecommendationRequest request) {
		return modelRepository.findMostRecommendedModelByCondition(request.getExperience(), request.getFamily(),
				request.getPurpose(), request.getValue(), request.getMinBudget(), request.getMaxBudget())
			.orElseThrow(() -> new ModelNotFoundException(ResultCode.SURVEY_NOT_FOUND));
	}

	private List<AdditionalOptionInfo> getMostRecommendedTwoOptions(RecommendationRequest request, Model model) {
		List<AdditionalOptionInfo> twoOptions = optionInfoRepository.findMostRecommendedOptionByCondition(
			request.getExperience(), request.getFamily(),
			request.getPurpose(), request.getValue(), request.getMinBudget(), request.getMaxBudget(), model.getId());
		validateRecommendedOptionCount(twoOptions.size());
		return twoOptions;
	}

	private void validateRecommendedOptionCount(int optionSize) {
		if (optionSize != 2) {
			throw new InvalidOptionException(ResultCode.INVALID_RECOMMENDED_OPTION_SIZE);
		}
	}

	private String generateReasonByChatGPT(RecommendationRequest request, AdditionalOptionInfo option) {
		List<String> reasons = recommendedOptionRepository.findRecommendReasonsByCondition(
			request.getExperience(), request.getFamily(), request.getPurpose(), request.getValue(), option.getId());

		// TODO : call AWS lambda
		/**
		 * POST https://dxts501dik.execute-api.ap-northeast-2.amazonaws.com/stage/generate-reason
		 *
		 * REQUEST
		 * {
		 *     "reasons" : ["운전 중에도 무릎의 따뜻함을 항상 느낄 수 있게 해줍니다."
		 *     ,"무릎을 따뜻하게 해주면서 건강까지 지켜주는 놀라운 옵션!"
		 *     ,"겨울 운전 중 저체온증을 예방하는 데 도움을 줍니다."
		 *     ,"냉기로부터 무릎을 보호하는 가장 현대적인 방법입니다."
		 *     ,"겨울의 까칠한 무릎 문제를 해결하는 스마트한 방법!"]
		 * }
		 *
		 * RESPONSE
		 * "블랙톤 휠은 운전 중에도 무릎의 따뜻함을 느낄 수 있도록 해요."
		 */

		return reasons.get(0);
	}
}
