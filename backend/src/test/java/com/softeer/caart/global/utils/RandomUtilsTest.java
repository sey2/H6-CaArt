package com.softeer.caart.global.utils;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
	@Test
	@DisplayName("예산을 4200부터 6900까지 랜덤하게 가져온다")
	void generateBudgetRandomly() {
		// given, when
		int budget = RandomUtils.generateBudgetRandomly();

		// then
		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThat(budget).isGreaterThanOrEqualTo(4200);
			softAssertions.assertThat(budget).isLessThanOrEqualTo(6900);
		});
	}
}