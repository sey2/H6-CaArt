package com.softeer.caart.domain.option.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

public interface BaseOptionInfoRepository extends JpaRepository<BaseOptionInfo, Long> {

	@Query(value = "select boi "
		+ "from BaseOptionInfo boi "
		+ "join AvailableOption ao on boi.id = ao.baseOptionInfo.id "
		+ "where ao.model.id = :modelId and boi.isBasic = true")
	Page<BaseOptionInfo> findByModelId(Long modelId, Pageable pageable);

	@Query(value = "select boi "
		+ "from BaseOptionInfo boi "
		+ "join AvailableOption ao on boi.id = ao.baseOptionInfo.id "
		+ "join OptionTag ot on boi.id = ot.option.id "
		+ "where ao.model.id = :modelId and boi.isBasic = true and ot.tag.id = :tagId")
	Page<BaseOptionInfo> findByModelIdAndTagId(Long modelId, Long tagId, Pageable pageable);

}
