package com.softeer.caart.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softeer.caart.domain.model.entity.AvailableOption;

public interface AvailableOptionRepository extends JpaRepository<AvailableOption, Long> {

	@Query(value = "select ao "
		+ "from AvailableOption ao "
		+ "join ao.baseOptionInfo boi "
		+ "join AdditionalOptionInfo aoi on boi.id = aoi.details.id "
		+ "where ao.model.id = :modelId and aoi.id = :additionalOptionId "
	)
	AvailableOption findByModelIdAndAdditionalOptionId(@Param("modelId") Long modelId,
		@Param("additionalOptionId") Long additionalOptionId);
}
