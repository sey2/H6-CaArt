package com.softeer.caart.domain.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

	@Query(value = "SELECT * FROM Model WHERE trim_id = ?1 AND car_engine_id = ?2 AND body_type_id = ?3 AND wd_id = ?4", nativeQuery = true)
	Optional<Model> findModelByTrimIdAndCompositionsId(Long trimId, Long engineId, Long bodyTypeId, Long wdId);
}