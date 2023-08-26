package com.softeer.caart.domain.color.entity;

import lombok.Getter;

@Getter
public enum AgeGroup {
	TWENTY(20, 29, "20대"),
	THIRTY(30, 39, "30대"),
	FORTY(40, 49, "40대"),
	FIFTY_OR_ABOVE(50, 79, "50대 이상"),
	ALL(20, 79, " ");

	private final int beginning;
	private final int end;
	private final String text;

	AgeGroup(int beginning, int end, String text) {
		this.beginning = beginning;
		this.end = end;
		this.text = text;
	}
}
