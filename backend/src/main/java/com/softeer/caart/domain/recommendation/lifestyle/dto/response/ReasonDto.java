package com.softeer.caart.domain.recommendation.lifestyle.dto.response;

import lombok.Getter;

@Getter
public class ReasonDto {
	private int statusCode;
	private String body;

	@Override
	public String toString() {
		return "ReasonResponse{" +
			"statusCode=" + statusCode +
			", body='" + body + '\'' +
			'}';
	}
}
