package com.softeer.caart.domain.color.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColorTest {
	@Test
	@DisplayName("외장색상이면 true를 반환한다")
	void isExterior() {
		// given
		Color color = Color.builder()
			.name("BLACK")
			.price(0)
			.imageUrl("image")
			.isExterior(true)
			.build();

		// when
		boolean exterior = color.isExterior();

		// then
		assertTrue(exterior);
	}

	@Test
	@DisplayName("내장색상이면 true를 반환한다")
	void isInterior() {
		// given
		Color color = Color.builder()
			.name("BLACK")
			.price(0)
			.imageUrl("image")
			.isExterior(false)
			.build();

		// when
		boolean interior = color.isInterior();

		// then
		assertTrue(interior);
	}

}
