package com.softeer.caart.domain.composition.dto.response;

import com.softeer.caart.domain.composition.entity.CarEngine;

import lombok.Getter;

@Getter
public class CarEngineSummaryResponse {
	private final Long engineId;
	private final String engineName;
	private final Integer enginePrice;

	private CarEngineSummaryResponse(CarEngine engine) {
		this.engineId = engine.getId();
		this.engineName = engine.getName();
		this.enginePrice = engine.getPrice();
	}

	public static CarEngineSummaryResponse from(CarEngine engine) {
		return new CarEngineSummaryResponse(engine);
	}
}
