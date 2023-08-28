package com.softeer.caart.domain.option.service;

import static com.softeer.caart.global.ResultCode.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.model.exception.ModelNotFoundException;
import com.softeer.caart.domain.model.repository.ModelRepository;
import com.softeer.caart.domain.option.dto.AdditionalOptionDetailsDto;
import com.softeer.caart.domain.option.dto.PositionResponse;
import com.softeer.caart.domain.option.dto.request.OptionListRequest;
import com.softeer.caart.domain.option.dto.request.OptionSummaryListRequest;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionResponse;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionSummaryResponse;
import com.softeer.caart.domain.option.dto.response.AdditionalOptionsResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionResponse;
import com.softeer.caart.domain.option.dto.response.BasicOptionsResponse;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.option.entity.AvailableOption;
import com.softeer.caart.domain.option.entity.BaseOptionInfo;
import com.softeer.caart.domain.option.entity.Position;
import com.softeer.caart.domain.option.exception.OptionNotFoundException;
import com.softeer.caart.domain.option.repository.AdditionalOptionInfoRepository;
import com.softeer.caart.domain.option.repository.AvailableOptionRepository;
import com.softeer.caart.domain.option.repository.BaseOptionInfoRepository;
import com.softeer.caart.domain.option.repository.PositionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OptionService {

	private final BaseOptionInfoRepository baseOptionInfoRepository;
	private final AdditionalOptionInfoRepository additionalOptionInfoRepository;
	private final ModelRepository modelRepository;
	private final AvailableOptionRepository availableOptionRepository;
	private final PositionRepository positionRepository;

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

	public BasicOptionsResponse getBasicOptions(OptionListRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(
				dto.getTrimId(), dto.getEngineId(), dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));

		Page<BaseOptionInfo> baseOptionInfos = fetchBasicOptionsByTagIdStatus(model.getId(), dto.getTagId(),
			dto.getOffset(), dto.getPageSize());

		return BasicOptionsResponse.from(baseOptionInfos);
	}

	private Page<BaseOptionInfo> fetchBasicOptionsByTagIdStatus(Long modelId, Long tagId,
		Integer offset, Integer pageSize) {
		Pageable pageable = PageRequest.of(offset, pageSize);
		if (isTagIdEmpty(tagId)) {
			return baseOptionInfoRepository.findByModelId(modelId, pageable);
		}
		return baseOptionInfoRepository.findByModelIdAndTagId(modelId, tagId, pageable);
	}

	public AdditionalOptionsResponse getAdditionalOptions(OptionListRequest dto) {
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(
				dto.getTrimId(), dto.getEngineId(), dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));

		Page<AdditionalOptionInfo> additionalOptionsPage = fetchAdditionalOptionsByTagIdStatus(
			model.getId(), dto.getTagId(), dto.getOffset(), dto.getPageSize());

		List<AdditionalOptionDetailsDto> additionalOptionDetails = getAdditionalOptionDetails(model,
			additionalOptionsPage, dto);

		return AdditionalOptionsResponse.from(additionalOptionsPage.getTotalElements(),
			additionalOptionsPage.getTotalPages(), additionalOptionDetails);
	}
	
	private List<AdditionalOptionDetailsDto> getAdditionalOptionDetails(Model model,
		Page<AdditionalOptionInfo> additionalOptionsPage, OptionListRequest dto) {
		List<AdditionalOptionDetailsDto> optionDetails = new ArrayList<>();
		for (AdditionalOptionInfo additionalOptionInfo : additionalOptionsPage) {
			// 채택률
			AvailableOption availableOption = availableOptionRepository.findByModelIdAndAdditionalOptionId(
				model.getId(), additionalOptionInfo.getId());
			// 위치 좌표
			PositionResponse position = getPosition(dto, additionalOptionInfo);
			optionDetails.add(
				AdditionalOptionDetailsDto.from(additionalOptionInfo, availableOption.getAdoptionRateAll(), position));
		}
		optionDetails.sort(Comparator.comparingDouble(AdditionalOptionDetailsDto::getAdoptionRate).reversed());

		return optionDetails;
	}

	private PositionResponse getPosition(OptionListRequest dto, AdditionalOptionInfo additionalOptionInfo) {
		Optional<Position> position = positionRepository.findByAdditionalOptionIdAndTagId(
			additionalOptionInfo.getId(), dto.getTagId());
		return position.map(PositionResponse::from).orElse(null);
	}

	private Page<AdditionalOptionInfo> fetchAdditionalOptionsByTagIdStatus(
		Long modelId, Long tagId, Integer offset, Integer pageSize) {
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
		Model model = modelRepository.findModelByTrimIdAndCompositionsId(
				dto.getTrimId(), dto.getEngineId(), dto.getBodyTypeId(), dto.getWdId())
			.orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND));
		List<AdditionalOptionInfo> additionalOptions = additionalOptionInfoRepository
			.findAdditionalOptionInfosByModelId(model.getId());

		return additionalOptions.stream()
			.map(AdditionalOptionSummaryResponse::from)
			.collect(Collectors.toList());
	}
}
