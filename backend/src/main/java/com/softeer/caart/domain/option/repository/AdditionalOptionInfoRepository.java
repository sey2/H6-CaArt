package com.softeer.caart.domain.option.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.option.dto.PurchasedOptionCountDto;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

public interface AdditionalOptionInfoRepository extends JpaRepository<AdditionalOptionInfo, Long> {

	@Query(value = "select aoi "
		+ "from AdditionalOptionInfo aoi "
		+ "join AvailableOption ao on aoi.details.id = ao.baseOptionInfo.id "
		+ "where ao.model.id = :modelId")
	Page<AdditionalOptionInfo> findByModelId(Long modelId, Pageable pageable);

	@Query(value = "select aoi "
		+ "from AdditionalOptionInfo aoi "
		+ "join aoi.details boi "
		+ "join boi.tags tags "
		+ "join AvailableOption ao on aoi.details.id = ao.baseOptionInfo.id "
		+ "where ao.model.id = :modelId and tags.tag.id = :tagId")
	Page<AdditionalOptionInfo> findByModelIdAndTagId(Long modelId, Long tagId, Pageable pageable);

	@Query(value = "select aoi "
		+ "from AdditionalOptionInfo aoi "
		+ "join fetch aoi.details boi "
		+ "join AvailableOption ao on ao.baseOptionInfo.id = boi.id "
		+ "where ao.model.id = :modelId")
	List<AdditionalOptionInfo> findAdditionalOptionInfosByModelId(Long modelId);

	@Query(value = "select "
		+ "p.model_id as modelId, "
		+ "o.additional_option_info_id as optionId, "
		+ "COUNT(*) as count "
		+ "from purchase p "
		+ "left outer join rel_purchase_additional_option o on p.purchase_id = o.purchase_id "
		+ "group by p.model_id, o.additional_option_info_id",
		nativeQuery = true)
	List<PurchasedOptionCountDto> countPurchasedOption();

	/**
	 * 추천 가장 많이 받은 modelId의 설문들 중에 추천 가장 많이 받은 옵션 2개 가져오기
	 */
	@Query(value = "SELECT aoi.* FROM car_master_survey cms "
		+ "JOIN recommended_option ro ON cms.car_master_survey_id = ro.car_master_survey_id "
		+ "JOIN additional_option_info aoi ON ro.additional_option_info_id = aoi.additional_option_info_id "
		+ "WHERE cms.model_id = :mostRecommendedModelId"
		+ "    AND cms.experience_code = :#{#experience.name()}"
		+ "    AND cms.purpose_code = :#{#purpose.name()}"
		+ "    AND cms.value_code = :#{#value.name()}"
		+ "    AND cms.family_code = :#{#family.name()}"
		+ "    AND cms.total_sum BETWEEN :minBudget AND :maxBudget "
		+ "GROUP BY ro.additional_option_info_id "
		+ "ORDER BY COUNT(*) DESC "
		+ "LIMIT 2", nativeQuery = true)
	List<AdditionalOptionInfo> findMostRecommendedOptionByCondition(Answer experience, Answer family, Answer purpose,
		Answer value, Integer minBudget, Integer maxBudget, Long mostRecommendedModelId);
}
