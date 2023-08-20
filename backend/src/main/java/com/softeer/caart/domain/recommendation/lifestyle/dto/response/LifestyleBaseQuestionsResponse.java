package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import static com.softeer.caart.domain.recommendation.lifestyle.dto.LifestyleQuestionDto.*;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.recommendation.lifestyle.entity.Question;
import com.softeer.caart.domain.recommendation.persona.dto.PersonaResponse;

import lombok.Getter;

@Getter
public class LifestyleBaseQuestionsResponse {
	private final QuestionDto age;
	private final PersonaQuestionDto persona;

	private LifestyleBaseQuestionsResponse(List<PersonaResponse> personas) {
		this.age = new QuestionDto(Question.AGE);
		this.persona = new PersonaQuestionDto(Question.PERSONA, personas);
	}

	public static LifestyleBaseQuestionsResponse create() {
		return new LifestyleBaseQuestionsResponse(new ArrayList<>());
	}

	public static LifestyleBaseQuestionsResponse from(List<PersonaResponse> personas) {
		return new LifestyleBaseQuestionsResponse(personas);
	}
}
