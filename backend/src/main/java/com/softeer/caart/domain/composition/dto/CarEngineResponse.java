package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.CarEngine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarEngineResponse {
	private String name;
	private String description;
	private Integer price;
	private String maxPower;
	private String maxTorque;
	private String image;

	private CarEngineResponse(CarEngine carEngine) {
		this.name = carEngine.getName();
		this.description = carEngine.getDescription();
		this.price = carEngine.getPrice();
		this.maxPower = carEngine.getMaxPower();
		this.maxTorque = carEngine.getMaxTorque();
		this.image = carEngine.getImage().getUrl();
	}

	public static CarEngineResponse from(CarEngine carEngine) {
		return new CarEngineResponse(carEngine);
	}
}
