package com.softeer.caart.domain.recommendation.persona.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.recommendation.persona.entity.RecommendationResult;

public interface RecommendationResultRepository extends JpaRepository<RecommendationResult, Long> {

	Optional<RecommendationResult> findByPersona_Id(Long personaId);
}
