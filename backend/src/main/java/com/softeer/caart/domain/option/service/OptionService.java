package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.option.dto.BaseOptionResponse;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.OptionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class OptionService {

	private final OptionRepository optionRepository;

	public BaseOptionResponse getOption(Long optionId) {
		BaseOptionInfo option = optionRepository.findById(optionId)
			.orElseThrow(() -> new OptionNotFoundException(OPTION_NOT_FOUND));

		return BaseOptionResponse.from(option);
	}
}
