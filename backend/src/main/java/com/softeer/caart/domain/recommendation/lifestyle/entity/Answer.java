package com.softeer.caart.domain.recommendation.lifestyle.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Answer {
	ONE_YEAR("1년 이하", Question.EXPERIENCE),
	ONE_TO_FIVE_YEAR("1년 이상 ~ 5년 미만", Question.EXPERIENCE),
	FIVE_YEAR("5년 이상", Question.EXPERIENCE),

	SINGLE("1인", Question.FAMILY),
	COUPLE("2인", Question.FAMILY),
	SMALL("3~4인", Question.FAMILY),
	BIG("5인 이상", Question.FAMILY),

	COMMUTING("출퇴근용", Question.PURPOSE),
	LEISURE("레저용", Question.PURPOSE),
	HOME("가정용", Question.PURPOSE),
	BUSINESS("업무용", Question.PURPOSE),

	DESIGN("디자인", Question.VALUE),
	PERFORMANCE("성능", Question.VALUE),
	SAFETY("안전", Question.VALUE),
	CONVENIENCE("편의성", Question.VALUE),

	TWENTY("20대", Question.AGE),
	THIRTY("30대", Question.AGE),
	FORTY("40대", Question.AGE),
	FIFTY_OR_ABOVE("50대 이상", Question.AGE),
	;

	private final String answer;
	private final Question question;
}
