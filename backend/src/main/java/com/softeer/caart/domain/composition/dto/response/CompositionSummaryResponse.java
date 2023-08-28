package com.softeer.caart.domain.composition.dto.response;

import java.util.List;

import lombok.Getter;

@Getter
public class CompositionSummaryResponse {
	private final List<CarEngineSummaryResponse> carEngines;
	private final List<BodyTypeSummaryResponse> bodyTypes;
	private final List<WheelDriveSummaryResponse> wheelDrives;

	private CompositionSummaryResponse(List<CarEngineSummaryResponse> carEngines,
		List<BodyTypeSummaryResponse> bodyTypes, List<WheelDriveSummaryResponse> wheelDrives) {
		this.carEngines = carEngines;
		this.bodyTypes = bodyTypes;
		this.wheelDrives = wheelDrives;
	}

	public static CompositionSummaryResponse of(List<CarEngineSummaryResponse> engines,
		List<BodyTypeSummaryResponse> bodyTypes, List<WheelDriveSummaryResponse> wheelDrives) {
		return new CompositionSummaryResponse(engines, bodyTypes, wheelDrives);
	}
}
