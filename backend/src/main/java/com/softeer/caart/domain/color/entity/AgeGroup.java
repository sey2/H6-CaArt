package com.softeer.caart.domain.color.entity;

import lombok.Getter;

@Getter
public enum AgeGroup {
	TWENTY(20, 29),
	THIRTY(30, 39),
	FORTY(40, 49),
	FIFTY_OR_ABOVE(50, 79),
	ALL(20, 79);

	private final int beginning;
	private final int end;

	AgeGroup(int beginning, int end) {
		this.beginning = beginning;
		this.end = end;
	}
}
