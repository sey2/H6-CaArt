package com.softeer.caart.domain.option.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

public interface AdditionalOptionInfoRepository extends JpaRepository<AdditionalOptionInfo, Long> {
	// TODO : order by 채택률 desc
	// TODO : convert native @Query to QueryDSL
	@Query(value = "SELECT aoi.* FROM additional_option_info aoi JOIN rel_model_base_option_info rmboi on aoi.base_option_info_id = rmboi.base_option_info_id WHERE rmboi.model_id = :modelId",
		countQuery = "SELECT COUNT(*) FROM additional_option_info aoi JOIN rel_model_base_option_info rmboi on aoi.base_option_info_id = rmboi.base_option_info_id WHERE rmboi.model_id = :modelId",
		nativeQuery = true)
	Page<AdditionalOptionInfo> findByModelId(Long modelId, Pageable pageable);

	@Query(value = "SELECT aoi.* FROM additional_option_info aoi JOIN rel_model_base_option_info rmboi ON aoi.base_option_info_id = rmboi.base_option_info_id JOIN rel_tag_base_option_info rtboi on rmboi.base_option_info_id = rtboi.base_option_info_id WHERE rmboi.model_id = :modelId AND rtboi.tag_id = :tagId",
		countQuery = "SELECT COUNT(*) FROM additional_option_info aoi JOIN rel_model_base_option_info rmboi ON aoi.base_option_info_id = rmboi.base_option_info_id JOIN rel_tag_base_option_info rtboi on rmboi.base_option_info_id = rtboi.base_option_info_id WHERE rmboi.model_id = :modelId AND rtboi.tag_id = :tagId",
		nativeQuery = true)
	Page<AdditionalOptionInfo> findByModelIdAndTagId(Long modelId, Long tagId, Pageable pageable);

	@Query(value = "SELECT aoi.* FROM additional_option_info aoi "
		+ "JOIN rel_model_base_option_info rmboi on aoi.base_option_info_id = rmboi.base_option_info_id "
		+ "WHERE rmboi.model_id = :modelId"
		, nativeQuery = true)
	List<AdditionalOptionInfo> findAdditionalOptionInfosByModelId(Long modelId);
}
