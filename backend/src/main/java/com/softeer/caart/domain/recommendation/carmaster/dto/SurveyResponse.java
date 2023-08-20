package com.softeer.caart.domain.recommendation.carmaster.dto;

import java.util.List;

import com.softeer.caart.domain.composition.dto.response.CompositionSummaryResponse;
import com.softeer.caart.domain.recommendation.lifestyle.dto.LifestyleQuestionDto.AnswerDto;
import com.softeer.caart.domain.recommendation.lifestyle.entity.Question;
import com.softeer.caart.domain.trim.dto.response.TrimSummaryResponse;
import com.softeer.caart.global.utils.RandomUtils;

import lombok.Getter;

@Getter
public class SurveyResponse {
	private AnswerDto experience;
	private AnswerDto family;
	private AnswerDto purpose;
	private AnswerDto value;
	private Integer budgetRange;

	private List<TrimSummaryResponse> trims;
	private CompositionSummaryResponse compositions;

	private SurveyResponse(List<TrimSummaryResponse> trims, CompositionSummaryResponse compositions) {
		this.experience = new AnswerDto(Question.generateAnswerFrom(Question.EXPERIENCE));
		this.family = new AnswerDto(Question.generateAnswerFrom(Question.FAMILY));
		this.purpose = new AnswerDto(Question.generateAnswerFrom(Question.PURPOSE));
		this.value = new AnswerDto(Question.generateAnswerFrom(Question.VALUE));
		this.budgetRange = RandomUtils.generateBudgetRandomly();
		this.trims = trims;
		this.compositions = compositions;
	}

	public static SurveyResponse of(List<TrimSummaryResponse> trims, CompositionSummaryResponse composition) {
		return new SurveyResponse(trims, composition);
	}
}
