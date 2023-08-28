package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.LifestyleQuestionDto.*;

import com.softeer.caart.domain.recommendation.lifestyle.entity.Question;

import lombok.Getter;

@Getter
public class LifestyleAdditionalQuestionsResponse {
	private final QuestionDto experience;
	private final QuestionDto family;
	private final QuestionDto purpose;
	private final QuestionDto value;
	private final BudgetQuestionDto budget;

	private LifestyleAdditionalQuestionsResponse() {
		this.experience = new QuestionDto(Question.EXPERIENCE);
		this.family = new QuestionDto(Question.FAMILY);
		this.purpose = new QuestionDto(Question.PURPOSE);
		this.value = new QuestionDto(Question.VALUE);
		this.budget = new BudgetQuestionDto();
	}

	public static LifestyleAdditionalQuestionsResponse create() {
		return new LifestyleAdditionalQuestionsResponse();
	}
}
