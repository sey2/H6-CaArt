package com.softeer.caart.global.response;

import java.util.List;

import com.softeer.caart.global.ResultCode;

import lombok.Getter;

@Getter
public class ErrorListResponseDto {
	private final Boolean success;
	private final Integer statusCode;
	private final List<String> messages;

	private ErrorListResponseDto(Integer statusCode, List<String> messages) {
		this.success = false;
		this.statusCode = statusCode;
		this.messages = messages;
	}

	public static ErrorListResponseDto of(ResultCode resultCode, List<String> messages) {
		return new ErrorListResponseDto(resultCode.getStatusCode(), messages);
	}
}
