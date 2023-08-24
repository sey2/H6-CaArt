package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;

import lombok.Getter;

@Getter
public class RecommendationResponse {

	private final String palisadeImage = "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png";
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private RecommendationResponse(Model model, List<RecommendedOptionDto> recommendedOptions) {
		this.model = RecommendedModelDto.from(model);
		this.colors = new ArrayList<>(); // FIXME (to Min A)
		this.options = recommendedOptions;
		this.totalPrice = model.calcModelPrice() + options.get(0).getOptionPrice() + options.get(1).getOptionPrice();
	}

	public static RecommendationResponse of(Model model, List<AdditionalOptionInfo> options
		, String reason1, String reason2) {
		RecommendedOptionDto option1 = RecommendedOptionDto.of(options.get(0), reason1);
		RecommendedOptionDto option2 = RecommendedOptionDto.of(options.get(1), reason2);
		return new RecommendationResponse(model, List.of(option1, option2));
	}
}
