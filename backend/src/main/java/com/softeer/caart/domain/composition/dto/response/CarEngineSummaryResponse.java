package com.softeer.caart.domain.composition.dto.response;

import com.softeer.caart.domain.composition.entity.CarEngine;

import lombok.Getter;

@Getter
public class CarEngineSummaryResponse {
	private final Long engineId;
	private final String engineName;

	private CarEngineSummaryResponse(CarEngine engine) {
		this.engineId = engine.getId();
		this.engineName = engine.getName();
	}

	public static CarEngineSummaryResponse from(CarEngine engine) {
		return new CarEngineSummaryResponse(engine);
	}
}
