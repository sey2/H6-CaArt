package com.softeer.caart.domain.recommendation.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.recommendation.persona.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
