package com.softeer.caart.domain.option.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

public interface BaseOptionInfoRepository extends JpaRepository<BaseOptionInfo, Long> {
	// TODO : order by 채택률 desc
	// TODO : convert @Query to QueryDSL
	@Query(value = "SELECT boi.* FROM base_option_info boi JOIN rel_model_base_option_info rmboi on boi.base_option_info_id = rmboi.base_option_info_id WHERE rmboi.model_id = :modelId AND boi.is_basic = TRUE",
		countQuery = "SELECT COUNT(*) FROM base_option_info boi JOIN rel_model_base_option_info rmboi on boi.base_option_info_id = rmboi.base_option_info_id WHERE rmboi.model_id = :modelId AND boi.is_basic = TRUE",
		nativeQuery = true)
	Page<BaseOptionInfo> findByModelId(Long modelId, Pageable pageable);

	@Query(value = "SELECT boi.* FROM base_option_info boi JOIN rel_model_base_option_info rmboi ON boi.base_option_info_id = rmboi.base_option_info_id JOIN rel_tag_base_option_info rtboi on boi.base_option_info_id = rtboi.base_option_info_id WHERE rmboi.model_id = :modelId AND rtboi.tag_id = :tagId",
		countQuery = "SELECT COUNT(*) FROM base_option_info boi JOIN rel_model_base_option_info rmboi ON boi.base_option_info_id = rmboi.base_option_info_id JOIN rel_tag_base_option_info rtboi on boi.base_option_info_id = rtboi.base_option_info_id WHERE rmboi.model_id = :modelId AND rtboi.tag_id = :tagId",
		nativeQuery = true)
	Page<BaseOptionInfo> findByModelIdAndTagId(Long modelId, Long tagId, Pageable pageable);

}
