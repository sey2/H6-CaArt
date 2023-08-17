package com.softeer.caart.domain.option.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.softeer.caart.domain.option.entity.BaseOptionInfo;

import lombok.Getter;

@Getter
public class BasicOptionsResponse {
	private Long totalElements;
	private Integer totalPages;
	private List<BasicOptionResponse> baseOptions;

	private BasicOptionsResponse(Page<BaseOptionInfo> page) {
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.baseOptions = page.getContent().stream()
			.map(BasicOptionResponse::from)
			.sorted(Comparator.comparing(BasicOptionResponse::getOptionName))
			.collect(Collectors.toList());
	}

	public static BasicOptionsResponse from(Page<BaseOptionInfo> page) {
		return new BasicOptionsResponse(page);
	}
}
