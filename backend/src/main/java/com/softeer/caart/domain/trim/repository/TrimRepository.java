package com.softeer.caart.domain.trim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softeer.caart.domain.trim.entity.Trim;

public interface TrimRepository extends JpaRepository<Trim, Long> {

	@Query(value = "select distinct t "
		+ "from Trim t "
		+ "join fetch t.availableColors ac "
		+ "join fetch ac.color c")
	List<Trim> findTrimsWithColors();
}
