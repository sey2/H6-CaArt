package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.model.Model;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.AdditionalOptionsRequest;
import com.softeer.caart.domain.option.dto.AdditionalOptionsResponse;
import com.softeer.caart.domain.option.dto.BasicOptionResponse;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.BaseOptionInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OptionService {

	private final BaseOptionInfoRepository baseOptionInfoRepository;
	private final AdditionalOptionInfoRepository additionalOptionInfoRepository;
	private final ModelRepository modelRepository;

	// FIXME : N+1
	public AdditionalOptionsResponse getAdditionalOptions(AdditionalOptionsRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(dto.getTrimId(), dto.getEngineId(),
				dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));
		model.validateTrim();

		Page<AdditionalOptionInfo> additionalOptionInfos = fetchByTagIdStatus(model.getId(), dto.getTagId(),
			dto.getOffset(), dto.getPageSize());

		return AdditionalOptionsResponse.of(additionalOptionInfos);
	}

	private Page<AdditionalOptionInfo> fetchByTagIdStatus(Long modelId, Long tagId, Integer offset, Integer pageSize) {
		Pageable pageable = PageRequest.of(offset, pageSize);
		if (tagId != null) {
			return additionalOptionInfoRepository.findByModelIdAndTagId(modelId, tagId, pageable);
		}
		return additionalOptionInfoRepository.findByModelId(modelId, pageable);
	}

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
