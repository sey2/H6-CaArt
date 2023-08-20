package com.softeer.caart.domain.recommendation.lifestyle.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuestionTest {
	@Test
	@DisplayName("현재 question 타입에 해당하는 질문들을 가져온다")
	void getAnswers() {
		// given
		final Question experience = Question.EXPERIENCE;

		// when
		List<Answer> answersOfExperience = experience.getAnswers();

		// then
		assertAll(
			() -> assertEquals(3, answersOfExperience.size())
		);
	}

	@Test
	@DisplayName("특정 Question의 답변을 랜덤으로 하나 가져온다")
	void generateAnswerFrom() {
		// given
		final Question experience = Question.EXPERIENCE;

		// when
		final Answer answerOfExperience = Question.generateAnswerFrom(experience);
		System.out.println("answerOfExperience = " + answerOfExperience);

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(answerOfExperience).isNotNull();
			softAssertions.assertThat(isAnswerOfExperience(answerOfExperience)).isTrue();
		});
	}

	private boolean isAnswerOfExperience(Answer answer) {
		return answer == Answer.ONE_YEAR || answer == Answer.ONE_TO_FIVE_YEAR || answer == Answer.FIVE_YEAR;
	}
}