package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.LifestyleQuestionDto.*;

import com.softeer.caart.domain.recommendation.lifestyle.entity.QuestionType;

import lombok.Getter;

@Getter
public class LifestyleBaseQuestionsResponse {
	private final QuestionDto age;

	private LifestyleBaseQuestionsResponse() {
		this.age = new QuestionDto(QuestionType.AGE);
	}

	public static LifestyleBaseQuestionsResponse create() {
		return new LifestyleBaseQuestionsResponse();
	}
}
