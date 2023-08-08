package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.option.dto.CarOptionResponse;
import com.softeer.caart.domain.option.entity.CarOption;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.CarOptionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CarOptionService {

	private final CarOptionRepository carOptionRepository;

	public CarOptionResponse getOption(Long optionId) {
		CarOption option = carOptionRepository.findById(optionId)
			.orElseThrow(() -> new OptionNotFoundException(OPTION_NOT_FOUND));

		return CarOptionResponse.from(option);
	}
}
