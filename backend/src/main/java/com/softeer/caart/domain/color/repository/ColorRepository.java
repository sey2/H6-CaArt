package com.softeer.caart.domain.color.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softeer.caart.domain.color.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

	@Query(value = "select distinct c "
		+ "from Color c "
		+ "join c.relationsWithTrims r "
		+ "join fetch c.colorPreviews "
		+ "where r.trim.id = :trimId")
	List<Color> findColorsOfCurrentTrim(@Param("trimId") Long trimId);
}
