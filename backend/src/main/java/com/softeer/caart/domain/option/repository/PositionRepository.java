package com.softeer.caart.domain.option.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.option.entity.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

	@Query(value = "SELECT p.* FROM position p WHERE p.additional_option_info_id = :optionId AND p.tag_id = :tagId",
		nativeQuery = true)
	Optional<Position> findByAdditionalOptionIdAndTagId(Long optionId, Long tagId);
}
