package com.softeer.caart.domain.tag.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TagTest {
	@Test
	@DisplayName("대표 태그인지 확인한다")
	void isMainTag() {
		// given
		Tag mainTag = Tag.builder()
			.name("대표")
			.build();
		Tag notMainTag = Tag.builder()
			.name("")
			.build();

		// when
		boolean main = mainTag.isMainTag();
		boolean notMain = notMainTag.isMainTag();

		// then
		assertTrue(main);
		assertFalse(notMain);
	}

	@Test
	@DisplayName("엔터테인먼트 태그인지 확인한다")
	void isEntertainmentTag() {
		// given
		Tag entertainmentTag = Tag.builder()
			.name("엔터테인먼트")
			.build();
		Tag notEntertainmentTag = Tag.builder()
			.name("")
			.build();

		// when
		boolean entertainment = entertainmentTag.isEntertainmentTag();
		boolean notEntertainment = notEntertainmentTag.isEntertainmentTag();

		// then
		assertTrue(entertainment);
		assertFalse(notEntertainment);
	}
}