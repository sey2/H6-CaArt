package com.softeer.caart.domain.recommendation.lifestyle.entity;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;
import static com.softeer.caart.domain.recommendation.lifestyle.entity.Question.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softeer.caart.domain.recommendation.lifestyle.exception.InvalidAnswerException;
import com.softeer.caart.global.ResultCode;

class AnswerTest {
	@Test
	@DisplayName("운전경력에 대한 Answer가 아니면 예외를 던진다")
	void validateExperienceAnswer() {
		// given, when
		Answer wrongExperience = SINGLE;

		// then
		assertThatThrownBy(() -> wrongExperience.validateAnswer(EXPERIENCE))
			.isInstanceOf(InvalidAnswerException.class)
			.hasMessage(ResultCode.INVALID_ANSWER.getMessage());
	}

	@Test
	@DisplayName("가족에 대한 Answer가 아니면 예외를 던진다")
	void validateFamilyAnswer() {
		// given, when
		Answer wrongFamily = COMMUTING;

		// then
		assertThatThrownBy(() -> wrongFamily.validateAnswer(FAMILY))
			.isInstanceOf(InvalidAnswerException.class)
			.hasMessage(ResultCode.INVALID_ANSWER.getMessage());
	}

	@Test
	@DisplayName("목적에 대한 Answer가 아니면 예외를 던진다")
	void validatePurposeAnswer() {
		// given, when
		Answer wrongPurpose = SINGLE;

		// then
		assertThatThrownBy(() -> wrongPurpose.validateAnswer(PURPOSE))
			.isInstanceOf(InvalidAnswerException.class)
			.hasMessage(ResultCode.INVALID_ANSWER.getMessage());
	}

	@Test
	@DisplayName("가치관에 대한 Answer가 아니면 예외를 던진다")
	void validateValueAnswer() {
		// given, when
		Answer wrongValue = SINGLE;

		// then
		assertThatThrownBy(() -> wrongValue.validateAnswer(VALUE))
			.isInstanceOf(InvalidAnswerException.class)
			.hasMessage(ResultCode.INVALID_ANSWER.getMessage());
	}

}