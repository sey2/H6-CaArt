package com.softeer.caart.domain.tag.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.tag.dto.TagResponse;
import com.softeer.caart.domain.tag.repository.TagRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TagService {
	private final TagRepository tagRepository;

	// TODO : 추후 TagResponse에 priority 삭제
	// TODO : 정렬 관련 test code 작성
	public List<TagResponse> getTags() {
		return tagRepository.findAll().stream()
			.map(TagResponse::from)
			.sorted(Comparator.comparing(TagResponse::getPriority).reversed())
			.collect(Collectors.toList());
	}
}
