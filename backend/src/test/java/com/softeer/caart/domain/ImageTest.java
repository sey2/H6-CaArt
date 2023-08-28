package com.softeer.caart.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImageTest {
	@Test
	@DisplayName("정적 팩토리 메소드를 사용해서 Image 객체를 생성한다")
	void createImage() {
		// given
		String imageUrl = "image_url";

		// when
		Image image = Image.from(imageUrl);

		// then
		assertNotNull(image);
	}
}