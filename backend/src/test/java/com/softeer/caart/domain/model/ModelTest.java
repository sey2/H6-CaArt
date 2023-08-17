package com.softeer.caart.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.softeer.caart.domain.option.exception.InvalidOptionException;
import com.softeer.caart.domain.trim.entity.Trim;
import com.softeer.caart.global.ResultCode;

class ModelTest {
	@ParameterizedTest
	@ValueSource(strings = {"Exclusive", "Prestige", "Calligraphy"})
	@DisplayName("LeBlanc이 아닌 트림을 선택하면 예외를 던진다.")
	void validateTrim(String trimName) {
		// given, when
		Trim trim = Trim.builder()
			.name(trimName)
			.build();
		Model model = Model.builder()
			.trim(trim)
			.build();

		// then
		assertThatThrownBy(model::validateTrim)
			.isInstanceOf(InvalidOptionException.class)
			.hasMessage(ResultCode.INVALID_MODEL_ID.getMessage());
	}
}