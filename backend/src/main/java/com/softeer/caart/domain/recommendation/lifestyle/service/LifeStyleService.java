package com.softeer.caart.domain.recommendation.lifestyle.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.softeer.caart.domain.recommendation.lifestyle.dto.request.RecommendationRequest;
import com.softeer.caart.domain.recommendation.lifestyle.dto.response.RecommendationResponse;
import com.softeer.caart.domain.recommendation.lifestyle.repository.RecommendationResultRepository;
import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LifeStyleService {

	private final RecommendationResultRepository recommendationResultRepository;

	public RecommendationResponse getRecommendationByLifestyle(@Valid RecommendationRequest request) {
		// TODO: 카마스터 데이터를 기반으로 추천
		RecommendationResult recommendationResult = recommendationResultRepository.findById(1L)
			.orElseThrow(IllegalAccessError::new);
		return RecommendationResponse.from(recommendationResult);
	}
}
