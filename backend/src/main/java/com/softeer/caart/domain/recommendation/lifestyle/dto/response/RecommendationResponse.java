package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.RecommendedDto.*;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.color.entity.AvailableColor;
import com.softeer.caart.domain.model.entity.Model;
import com.softeer.caart.domain.option.entity.AdditionalOptionInfo;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Answer;

import lombok.Getter;

@Getter
public class RecommendationResponse {

	private final String palisadeImage = "https://caart-app-s3-bucket.s3.ap-northeast-2.amazonaws.com/image/palisade.png";
	private final RecommendedModelDto model;
	private final List<RecommendedColorDto> colors;
	private final List<RecommendedOptionDto> options;
	private final Integer totalPrice;

	private RecommendationResponse(Model model, List<AvailableColor> recommendedColorList,
		List<RecommendedOptionDto> recommendedOptions, Answer age) {
		this.model = RecommendedModelDto.from(model);
		this.colors = createRecommendedColorDtoList(recommendedColorList, age);
		this.options = recommendedOptions;
		this.totalPrice = model.calcModelPrice() + options.get(0).getOptionPrice() + options.get(1).getOptionPrice();
	}

	public static RecommendationResponse of(Model model, List<AvailableColor> recommendedColorList,
		List<AdditionalOptionInfo> options
		, String reason1, String reason2, Answer age) {
		RecommendedOptionDto option1 = RecommendedOptionDto.of(options.get(0), reason1);
		RecommendedOptionDto option2 = RecommendedOptionDto.of(options.get(1), reason2);
		return new RecommendationResponse(model, recommendedColorList, List.of(option1, option2), age);
	}

	private List<RecommendedColorDto> createRecommendedColorDtoList(List<AvailableColor> recommendedColorList,
		Answer age) {
		List<RecommendedColorDto> recommendedColorDtoList = new ArrayList<>();
		for (AvailableColor availableColor : recommendedColorList) {
			recommendedColorDtoList.add(
				new RecommendedColorDto(availableColor.getColor(), (int)availableColor.getAdoptionRate(age),
					Answer.getAge(age)));
		}
		return recommendedColorDtoList;
	}
}
