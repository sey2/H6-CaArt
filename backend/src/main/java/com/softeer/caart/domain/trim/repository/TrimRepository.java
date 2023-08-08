package com.softeer.caart.domain.trim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.trim.entity.Trim;

public interface TrimRepository extends JpaRepository<Trim, Long> {
}
