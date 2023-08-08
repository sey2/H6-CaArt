package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.WheelDrive;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WheelDriveResponse {
	private String name;
	private String description;
	private Integer price;
	private String image;

	public WheelDriveResponse(WheelDrive wheelDrive) {
		this.name = wheelDrive.getName();
		this.description = wheelDrive.getDescription();
		this.price = wheelDrive.getPrice();
		this.image = wheelDrive.getImage().getUrl();
	}

	public static WheelDriveResponse from(WheelDrive wheelDrive) {
		return new WheelDriveResponse(wheelDrive);
	}
}
