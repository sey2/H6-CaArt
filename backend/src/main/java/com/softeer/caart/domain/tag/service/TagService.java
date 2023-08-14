package com.softeer.caart.domain.tag.service;

import static org.springframework.data.domain.Sort.Direction.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.tag.dto.TagResponse;
import com.softeer.caart.domain.tag.repository.TagRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TagService {
	private final TagRepository tagRepository;

	public List<TagResponse> getTags() {
		return tagRepository.findAll(Sort.by(DESC, "priority")).stream()
			.map(TagResponse::from)
			.collect(Collectors.toList());
	}
}
