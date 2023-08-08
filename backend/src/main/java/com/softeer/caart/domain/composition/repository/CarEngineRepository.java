package com.softeer.caart.domain.composition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.composition.entity.CarEngine;

public interface CarEngineRepository extends JpaRepository<CarEngine, Long> {

}
