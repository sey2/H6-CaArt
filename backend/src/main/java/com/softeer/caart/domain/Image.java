package com.softeer.caart.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Image {

	@Column(name = "image")
	private String url;

	public boolean isNull() {
		return url.equals("null");
	}

	public static Image from(String url) {
		return new Image(url);
	}
}
