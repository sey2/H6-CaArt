package com.softeer.caart.domain.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

public interface OptionRepository extends JpaRepository<BaseOptionInfo, Long> {
}
