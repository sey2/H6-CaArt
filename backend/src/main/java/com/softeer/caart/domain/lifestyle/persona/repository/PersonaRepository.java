package com.softeer.caart.domain.lifestyle.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.lifestyle.persona.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
