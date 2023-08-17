package com.softeer.caart.domain.recommendation.lifestyle.entity;

import java.util.ArrayList;
import java.util.List;

import com.softeer.caart.domain.recommendation.lifestyle.dto.LifestyleQuestionDto.ChoiceDto;

import lombok.Getter;

@Getter
public enum QuestionType {

	EXPERIENCE("운전 경력이 어떻게 되세요?", "운전 경력"),
	FAMILY("가족 구성원이 몇 명인가요?", "가족 구성원"),
	PURPOSE("어떤 목적으로 주로 차를 타시나요?", "어떤 목적"),
	VALUE("자동차를 살 때 어떤 가치가 가장 중요한가요?", "어떤 가치"),
	BUDGET("최대 예산이 얼마인가요?", "최대 예산"),
	AGE("나이를 알려주세요.", "나이");

	private final String question;
	private final String keyword;

	QuestionType(String question, String keyword) {
		this.question = question;
		this.keyword = keyword;
	}

	private static List<String> getContentsOfExperience() {
		return List.of("1년 이하", "1년 이상 ~ 5년 미만", "5년 이상");
	}

	private static List<String> getContentsOfFamily() {
		return List.of("1인", "2인", "3~4인", "5인 이상");
	}

	private static List<String> getContentsOfPurpose() {
		return List.of("출퇴근용", "레저용", "가정용", "업무용");
	}

	private static List<String> getContentsOfValue() {
		return List.of("디자인", "성능", "안전", "편의성");
	}

	private static List<String> getContentsOfAge() {
		return List.of("20대", "30대", "40대", "50대 이상");
	}

	public static List<ChoiceDto> getChoiceDtoList(QuestionType type) {
		List<String> contents = new ArrayList<>();
		switch (type) {
			case EXPERIENCE:
				contents = getContentsOfExperience();
				break;
			case FAMILY:
				contents = getContentsOfFamily();
				break;
			case PURPOSE:
				contents = getContentsOfPurpose();
				break;
			case VALUE:
				contents = getContentsOfValue();
				break;
			case AGE:
				contents = getContentsOfAge();
				break;
			case BUDGET:
				return null;
		}

		List<ChoiceDto> choiceDtoList = new ArrayList<>();
		for (int id = 0; id < contents.size(); id++) {
			choiceDtoList.add(new ChoiceDto(id, contents.get(id)));
		}
		return choiceDtoList;
	}
}
