package com.softeer.caart.global.utils;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
	@Test
	@DisplayName("예산을 42000000부터 69000000까지 랜덤하게 가져온다")
	void generateBudgetRandomly() {
		// given, when
		int budget = RandomUtils.generateBudgetRandomly();

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(budget).isGreaterThanOrEqualTo(42000000);
			softAssertions.assertThat(budget).isLessThanOrEqualTo(69000000);
		});
	}
}