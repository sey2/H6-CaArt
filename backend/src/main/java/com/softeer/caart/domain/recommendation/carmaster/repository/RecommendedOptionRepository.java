package com.softeer.caart.domain.recommendation.carmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.recommendation.carmaster.entity.RecommendedOption;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

public interface RecommendedOptionRepository extends JpaRepository<RecommendedOption, Long> {

	/**
	 * 추천 받은 옵션의 사유 목록을 가져온다.
	 */
	@Query(value = "SELECT ro.reason FROM car_master_survey cms "
		+ "JOIN recommended_option ro ON cms.car_master_survey_id = ro.car_master_survey_id "
		+ "WHERE ro.additional_option_info_id = :additionalOptionId"
		+ "    AND cms.experience_code = :#{#experience.name()}"
		+ "    AND cms.purpose_code = :#{#purpose.name()}"
		+ "    AND cms.value_code = :#{#value.name()}"
		+ "    AND cms.family_code = :#{#family.name()} "
		+ "LIMIT 10", nativeQuery = true)
	List<String> findRecommendReasonsByCondition(Answer experience, Answer family, Answer purpose, Answer value,
		Long additionalOptionId);
}
