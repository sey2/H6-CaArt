package com.softeer.caart.domain.recommendation.carmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.recommendation.carmaster.entity.RecommendedOption;

public interface RecommendedOptionRepository extends JpaRepository<RecommendedOption, Long> {
}
