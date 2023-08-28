package com.softeer.caart.domain.option.dto;

import com.softeer.caart.domain.option.entity.Position;

import lombok.Getter;

@Getter
public class PositionResponse {
	private Double webX;
	private Double webY;
	private Double mobileX;
	private Double mobileY;

	private PositionResponse(Position position) {
		this.webX = position.getWebX();
		this.webY = position.getWebY();
		this.mobileX = position.getMobileX();
		this.mobileY = position.getMobileY();
	}

	public static PositionResponse from(Position position) {
		return new PositionResponse(position);
	}
}
