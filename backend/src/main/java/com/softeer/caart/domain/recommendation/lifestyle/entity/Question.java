package com.softeer.caart.domain.recommendation.lifestyle.entity;

import static com.softeer.caart.domain.recommendation.lifestyle.entity.Answer.*;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Question {

	EXPERIENCE("운전 경력이 어떻게 되세요?", "운전 경력", List.of(ONE_YEAR, ONE_TO_FIVE_YEAR, FIVE_YEAR)),
	FAMILY("가족 구성원이 몇 명인가요?", "가족 구성원", List.of(SINGLE, COUPLE, SMALL, BIG)),
	PURPOSE("어떤 목적으로 주로 차를 타시나요?", "어떤 목적", List.of(COMMUTING, LEISURE, HOME, BUSINESS)),
	VALUE("자동차를 살 때 어떤 가치가 가장 중요한가요?", "어떤 가치", List.of(DESIGN, PERFORMANCE, SAFETY, CONVENIENCE)),
	BUDGET("최대 예산이 얼마인가요?", "최대 예산", List.of()),
	AGE("나이를 알려주세요.", "나이", List.of(TWENTY, THIRTY, FORTY, FIFTY_OR_ABOVE)),
	;

	private final String content;
	private final String keyword;
	private final List<Answer> answers;

}
