package com.softeer.caart.domain.composition.dto.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompositionResponse {
	private List<CarEngineResponse> carEngines;
	private List<BodyTypeResponse> bodyTypes;
	private List<WheelDriveResponse> wheelDrives;

	private CompositionResponse(List<CarEngineResponse> carEngines, List<BodyTypeResponse> bodyTypes,
		List<WheelDriveResponse> wheelDrives) {
		this.carEngines = carEngines;
		this.bodyTypes = bodyTypes;
		this.wheelDrives = wheelDrives;
	}

	public static CompositionResponse from(List<CarEngineResponse> carEngines, List<BodyTypeResponse> bodyTypes,
		List<WheelDriveResponse> wheelDrives) {
		return new CompositionResponse(carEngines, bodyTypes, wheelDrives);
	}
}
