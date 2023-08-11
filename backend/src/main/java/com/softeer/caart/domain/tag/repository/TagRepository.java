package com.softeer.caart.domain.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.tag.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
