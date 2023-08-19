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

	// 기본 포함 옵션 태그 목록에는 모든 태그가 포함됨
	public List<TagResponse> getBasicOptionTags() {
		return tagRepository.findAll(Sort.by(DESC, "priority")).stream()
			.map(TagResponse::from)
			.collect(Collectors.toList());
	}

	// 추가 옵션 태그 목록에는 "대표", "엔터테인먼트" 태그가 제외됨
	public List<TagResponse> getAdditionalOptionTags() {
		return tagRepository.findAll(Sort.by(DESC, "priority")).stream()
			.filter(tag -> !tag.isMainTag() && !tag.isEntertainmentTag())
			.map(TagResponse::from)
			.collect(Collectors.toList());
	}
}
