package com.softeer.caart.domain.recommendation.lifestyle.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Answer {
	ONE_YEAR("1년 이하"),
	ONE_TO_FIVE_YEAR("1년 이상 ~ 5년 미만"),
	FIVE_YEAR("5년 이상"),

	SINGLE("1인"),
	COUPLE("2인"),
	SMALL("3~4인"),
	BIG("5인 이상"),

	COMMUTING("출퇴근용"),
	LEISURE("레저용"),
	HOME("가정용"),
	BUSINESS("업무용"),

	DESIGN("디자인"),
	PERFORMANCE("성능"),
	SAFETY("안전"),
	CONVENIENCE("편의성"),

	TWENTY("20대"),
	THIRTY("30대"),
	FORTY("40대"),
	FIFTY_OR_ABOVE("50대 이상"),
	;

	private final String answer;
}
