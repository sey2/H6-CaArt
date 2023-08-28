package com.softeer.caart.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {
	// 200 (정상)
	OK(200, "Success"),

	// 400
	INVALID_METHOD_ARGUMENT(400, "잘못된 인자입니다."),
	NULL_VALUE_ERROR(400, "Null 값이 올 수 없습니다."),
	INVALID_TYPE(400, "잘못된 타입입니다."),
	INVALID_JSON(400, "request 정보를 읽을 수 없습니다."),
	NOT_SATISFIED_DB_CONSTRAINT(400, "DB의 제약조건을 만족하지 않습니다."),
	INVALID_BASIC_OPTION(400, "기본 옵션이 아닙니다."),
	INVALID_ADDITIONAL_OPTION(400, "추가 옵션이 아닙니다."),
	INVALID_MODEL_ID(400, "Le Blanc 트림만 선택 가능합니다."),
	INVALID_REQUEST_PARAM(400, "잘못된 요청 파라미터입니다."),
	INVALID_ANSWER(400, "답변이 질문과 잘못 매핑되었습니다."),
	INVALID_BUDGET(400, "예산이 잘못 설정되었습니다."),
	INVALID_RECOMMENDED_OPTION_SIZE(400, "추천 받은 옵션의 개수는 2개여야 합니다"),
	INVALID_SURVEY(400, "조건에 해당하는 설문 결과가 없습니다."),
	INVALID_LAMBDA_CALL(400, "람다 API 호출에 실패했습니다."),

	// 404
	MODEL_NOT_FOUND(404, "존재하지 않는 모델입니다."),
	TRIM_NOT_FOUND(404, "존재하지 않는 트림입니다."),
	ENGINE_NOT_FOUND(404, "존재하지 않는 엔진입니다."),
	BODY_TYPE_NOT_FOUND(404, "존재하지 않는 바디타입입니다."),
	WHEEL_DRIVE_NOT_FOUND(404, "존재하지 않는 구동방식입니다."),
	OPTION_NOT_FOUND(404, "존재하지 않는 옵션입니다."),
	PERSONA_NOT_FOUND(404, "존재하지 않는 페르소나입니다."),

	// 405
	METHOD_NOT_ALLOWED(405, "대상 리소스가 이 메서드를 지원하지 않습니다."),

	// 500,
	INTERNAL_SERVER_ERROR(500, "서버에서 문제가 발생했습니다."),
	;

	private final int statusCode;
	private final String message;
}
