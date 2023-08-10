package com.softeer.caart.domain.trim.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.trim.dto.TrimResponse;
import com.softeer.caart.domain.trim.repository.TrimRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TrimService {
	private final TrimRepository trimRepository;

	public List<TrimResponse> getTrims() {
		return trimRepository.findAll().stream()
			.map(TrimResponse::from)
			.sorted(Comparator.comparing(TrimResponse::getTrimPrice))
			.collect(Collectors.toList());
	}
}
