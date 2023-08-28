package com.softeer.caart.domain.color.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.color.dto.PurchasedColorCountDto;
import com.softeer.caart.domain.color.entity.AvailableColor;

public interface AvailableColorRepository extends JpaRepository<AvailableColor, Long> {

	/**
	 * 특정 트림을 구매한 특정 연령대의 사람들이 각 외장 색상을 선택한 횟수를 조회한다
	 */
	@Query(value = "select p.exterior_color_id as colorId, count(*) as count "
		+ "from purchase p "
		+ "join model m on p.model_id = m.model_id "
		+ "where m.trim_id = :trimId and p.age between :beginning and :end "
		+ "group by p.exterior_color_id",
		nativeQuery = true)
	List<PurchasedColorCountDto> countPurchasedExteriorColorByAgeGroup(Long trimId, int beginning, int end);

	/**
	 * 특정 트림을 구매한 특정 연령대의 사람들이 각 내장 색상을 선택한 횟수를 조회한다.
	 */
	@Query(value = "select p.interior_color_id as colorId, count(*) as count "
		+ "from purchase p "
		+ "join model m on p.model_id = m.model_id "
		+ "where m.trim_id = :trimId and p.age between :beginning and :end "
		+ "group by p.interior_color_id",
		nativeQuery = true)
	List<PurchasedColorCountDto> countPurchasedInteriorColorByAgeGroup(Long trimId, int beginning, int end);

	/**
	 * 20대에서 가장 채택률이 높은 색상을 조회한다.
	 */
	@Query(value = "select rtc.* "
		+ "from rel_trim_color rtc "
		+ "join color c on rtc.color_id = c.color_id "
		+ "where rtc.trim_id = :trimId and c.is_exterior = :isExterior "
		+ "order by rtc.adoption_rate_twenty desc "
		+ "limit 1",
		nativeQuery = true)
	AvailableColor findMostAdoptedColorForTwenty(Long trimId, Boolean isExterior);

	/**
	 * 30대에서 가장 채택률이 높은 색상을 조회한다.
	 */
	@Query(value = "select rtc.* "
		+ "from rel_trim_color rtc "
		+ "join color c on rtc.color_id = c.color_id "
		+ "where rtc.trim_id = :trimId and c.is_exterior = :isExterior "
		+ "order by rtc.adoption_rate_thirty desc "
		+ "limit 1",
		nativeQuery = true)
	AvailableColor findMostAdoptedColorForThirty(Long trimId, Boolean isExterior);

	/**
	 * 40대에서 가장 채택률이 높은 색상을 조회한다.
	 */
	@Query(value = "select rtc.* "
		+ "from rel_trim_color rtc "
		+ "join color c on rtc.color_id = c.color_id "
		+ "where rtc.trim_id = :trimId and c.is_exterior = :isExterior "
		+ "order by rtc.adoption_rate_forty desc "
		+ "limit 1",
		nativeQuery = true)
	AvailableColor findMostAdoptedColorForForty(Long trimId, Boolean isExterior);

	/**
	 * 50대 이상에서 가장 채택률이 높은 색상을 조회한다.
	 */
	@Query(value = "select rtc.* "
		+ "from rel_trim_color rtc "
		+ "join color c on rtc.color_id = c.color_id "
		+ "where rtc.trim_id = :trimId and c.is_exterior = :isExterior "
		+ "order by rtc.adoption_rate_fifty_or_above desc "
		+ "limit 1",
		nativeQuery = true)
	AvailableColor findMostAdoptedColorForFiftyOrAbove(Long trimId, Boolean isExterior);

	/**
	 * 가장 채택률이 높은 색상을 조회한다. (전체 구매자 대상)
	 */
	@Query(value = "select rtc.* "
		+ "from rel_trim_color rtc "
		+ "join color c on rtc.color_id = c.color_id "
		+ "where rtc.trim_id = :trimId and c.is_exterior = :isExterior "
		+ "order by rtc.adoption_rate_all desc "
		+ "limit 1",
		nativeQuery = true)
	AvailableColor findMostAdoptedColorForAll(Long trimId, Boolean isExterior);

}
