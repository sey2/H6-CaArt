package com.softeer.caart.domain.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.option.entity.CarOption;

public interface CarOptionRepository extends JpaRepository<CarOption, Long> {
}
