package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.AdditionalOptionSummaryResponse;
import com.softeer.caart.domain.option.dto.AdditionalOptionsResponse;
import com.softeer.caart.domain.option.dto.BasicOptionResponse;
import com.softeer.caart.domain.option.dto.BasicOptionsResponse;
import com.softeer.caart.domain.option.dto.OptionListRequest;
import com.softeer.caart.domain.option.dto.OptionSummaryListRequest;
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

	// FIXME : N+1
	public BasicOptionsResponse getBasicOptions(OptionListRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(dto.getTrimId(), dto.getEngineId(),
				dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));

		Page<BaseOptionInfo> baseOptionInfos = fetchBasicOptionsByTagIdStatus(model.getId(), dto.getTagId(),
			dto.getOffset(), dto.getPageSize());

		return BasicOptionsResponse.from(baseOptionInfos);
	}

	private Page<BaseOptionInfo> fetchBasicOptionsByTagIdStatus(Long modelId, Long tagId, Integer offset,
		Integer pageSize) {
		Pageable pageable = PageRequest.of(offset, pageSize);
		if (isTagIdEmpty(tagId)) {
			return baseOptionInfoRepository.findByModelId(modelId, pageable);
		}
		return baseOptionInfoRepository.findByModelIdAndTagId(modelId, tagId, pageable);
	}

	// FIXME : N+1
	public AdditionalOptionsResponse getAdditionalOptions(OptionListRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(dto.getTrimId(), dto.getEngineId(),
				dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));

		Page<AdditionalOptionInfo> additionalOptionInfos = fetchAdditionalOptionsByTagIdStatus(model.getId(),
			dto.getTagId(),
			dto.getOffset(), dto.getPageSize());

		return AdditionalOptionsResponse.from(additionalOptionInfos);
	}

	private Page<AdditionalOptionInfo> fetchAdditionalOptionsByTagIdStatus(Long modelId, Long tagId, Integer offset,
		Integer pageSize) {
		Pageable pageable = PageRequest.of(offset, pageSize);
		if (isTagIdEmpty(tagId)) {
			return additionalOptionInfoRepository.findByModelId(modelId, pageable);
		}
		return additionalOptionInfoRepository.findByModelIdAndTagId(modelId, tagId, pageable);
	}

	private boolean isTagIdEmpty(Long tagId) {
		return tagId == null;
	}

	public List<AdditionalOptionSummaryResponse> getAdditionalOptionSummaries(OptionSummaryListRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(dto.getTrimId(), dto.getEngineId(),
				dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));
		List<AdditionalOptionInfo> additionalOptions = additionalOptionInfoRepository
			.findAdditionalOptionInfosByModelId(model.getId());

		return additionalOptions.stream()
			.map(AdditionalOptionSummaryResponse::from)
			.collect(Collectors.toList());
	}
}
