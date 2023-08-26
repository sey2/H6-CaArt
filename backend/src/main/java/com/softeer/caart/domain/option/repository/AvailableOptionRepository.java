package com.softeer.caart.domain.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softeer.caart.domain.option.entity.AvailableOption;

public interface AvailableOptionRepository extends JpaRepository<AvailableOption, Long> {

	/**
	 * 특정 모델(modelId)과 추가 옵션(additionalOptionId)에 대한 AvailableOption을 조회한다.
	 */
	@Query(value = "select ao "
		+ "from AvailableOption ao "
		+ "join ao.baseOptionInfo boi "
		+ "join AdditionalOptionInfo aoi on boi.id = aoi.details.id "
		+ "where ao.model.id = :modelId and aoi.id = :additionalOptionId ")
	AvailableOption findByModelIdAndAdditionalOptionId(@Param("modelId") Long modelId,
		@Param("additionalOptionId") Long additionalOptionId);
}
