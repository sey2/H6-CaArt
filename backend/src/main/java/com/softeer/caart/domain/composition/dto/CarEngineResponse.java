package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.CarEngine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarEngineResponse {
	private String engineName;
	private String description;
	private Integer enginePrice;
	private String maxPower;
	private String maxTorque;
	private String engineImage;

	private CarEngineResponse(CarEngine carEngine) {
		this.engineName = carEngine.getName();
		this.description = carEngine.getDescription();
		this.enginePrice = carEngine.getPrice();
		this.maxPower = carEngine.getMaxPower();
		this.maxTorque = carEngine.getMaxTorque();
		this.engineImage = carEngine.getImage().getUrl();
	}

	public static CarEngineResponse from(CarEngine carEngine) {
		return new CarEngineResponse(carEngine);
	}
}
