package com.softeer.caart.domain.recommendation.lifestyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

public interface RecommendationResultRepository extends JpaRepository<RecommendationResult, Long> {
}
