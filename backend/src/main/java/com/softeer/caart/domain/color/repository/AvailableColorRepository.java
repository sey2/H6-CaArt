package com.softeer.caart.domain.color.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AvailableColor;

public interface AvailableColorRepository extends JpaRepository<AvailableColor, Long> {

	@Query(value = "select p.exterior_color_id as colorId, count(*) as count "
		+ "from purchase p "
		+ "join model m on p.model_id = m.model_id "
		+ "where m.trim_id = :trimId and p.age between :beginning and :end "
		+ "group by p.exterior_color_id",
		nativeQuery = true)
	List<PurchasedColorCountDto> countPurchasedExteriorColorByAgeGroup(@Param("trimId") Long trimId,
		@Param("beginning") int beginning, @Param("end") int end);

	@Query(value = "select p.interior_color_id as colorId, count(*) as count "
		+ "from purchase p "
		+ "join model m on p.model_id = m.model_id "
		+ "where m.trim_id = :trimId and p.age between :beginning and :end "
		+ "group by p.interior_color_id",
		nativeQuery = true)
	List<PurchasedColorCountDto> countPurchasedInteriorColorByAgeGroup(@Param("trimId") Long trimId,
		@Param("beginning") int beginning, @Param("end") int end);
}
