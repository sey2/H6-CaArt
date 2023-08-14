package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.option.dto.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.BasicOptionResponse;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.BaseOptionInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class OptionService {

	private final BaseOptionInfoRepository baseOptionInfoRepository;
	private final AdditionalOptionInfoRepository additionalOptionInfoRepository;

	public BasicOptionResponse getBasicOption(Long optionId) {
		BaseOptionInfo option = baseOptionInfoRepository.findById(optionId)
			.orElseThrow(() -> new OptionNotFoundException(OPTION_NOT_FOUND));
		option.validateBasicOption();

		return BasicOptionResponse.from(option);
	}

	public AdditionalOptionResponse getAdditionalOption(Long optionId) {
		AdditionalOptionInfo option = additionalOptionInfoRepository.findById(optionId)
			.orElseThrow(() -> new OptionNotFoundException(OPTION_NOT_FOUND));
		option.validateAdditionalOption();

		return AdditionalOptionResponse.from(option);
	}
}
