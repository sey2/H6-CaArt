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

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {
	private final TagRepository tagRepository;
	private final String PRIORITY = "priority";

	public List<TagResponse> getBasicOptionTags() {
		return tagRepository.findAll(Sort.by(DESC, PRIORITY)).stream()
			.map(TagResponse::from)
			.collect(Collectors.toList());
	}

	public List<TagResponse> getAdditionalOptionTags() {
		return tagRepository.findAll(Sort.by(DESC, PRIORITY)).stream()
			.filter(tag -> !tag.isMainTag() && !tag.isEntertainmentTag())
			.map(TagResponse::from)
			.collect(Collectors.toList());
	}
}
