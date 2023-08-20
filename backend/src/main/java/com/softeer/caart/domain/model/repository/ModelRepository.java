package com.softeer.caart.domain.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.model.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	@Query(value = "SELECT * FROM model WHERE trim_id = :trimId AND car_engine_id = :engineId AND body_type_id = :bodyTypeId AND wd_id = :wdId", nativeQuery = true)
	Optional<Model> findModelByTrimIdAndCompositionsId(Long trimId, Long engineId, Long bodyTypeId, Long wdId);
}