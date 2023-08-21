package com.softeer.caart.domain.recommendation.carmaster.dto;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.softeer.caart.domain.recommendation.lifestyle.exception.InvalidAnswerException;
import com.softeer.caart.global.ResultCode;

class CreateSurveyRequestTest {
	@Test
	@DisplayName("운전경력에 대한 Answer가 올바른 Question에 매핑되어 있지 않으면 예외를 던진다.")
	void validateAnswer() {
		assertThatThrownBy(() -> new CreateSurveyRequest(SINGLE, SINGLE, COMMUTING, DESIGN, -1L,
			-1L,
			-1L,
			-1L, -1L, "사유1사유1", -1L,
			"사유2사유2", 0))
			.isInstanceOf(InvalidAnswerException.class)
			.hasMessage(ResultCode.INVALID_ANSWER.getMessage());
	}
}