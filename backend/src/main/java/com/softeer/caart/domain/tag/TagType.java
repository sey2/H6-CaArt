package com.softeer.caart.domain.tag;

public enum TagType {

	CONVENIENCE("사용편의"),
	SAFETY("주행안전"),
	TEMPERATURE("추위/더위"),
	ASSISTANCE("주차/출차"),
	STYLE("스타일"),
	PERFORMANCE("퍼포먼스"),
	ENTERTAINMENT("엔터테인먼트");

	private final String name;

	TagType(String name) {
		this.name = name;
	}
}
