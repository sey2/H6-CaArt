package com.softeer.caart.global.response;

import com.softeer.caart.global.ResultCode;

import lombok.Getter;

@Getter
public class DataResponseDto<T> extends ResponseDto {
	private final T data;

	private DataResponseDto(T data) {
		super(true, ResultCode.OK.getStatusCode(), ResultCode.OK.getMessage());
		this.data = data;
	}

	public static <T> DataResponseDto<T> of(T data) {
		return new DataResponseDto<>(data);
	}
}
