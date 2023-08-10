package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.WheelDrive;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WheelDriveResponse {
	private String wheelDriveName;
	private String description;
	private Integer wheelDrivePrice;
	private String wheelDriveImage;

	public WheelDriveResponse(WheelDrive wheelDrive) {
		this.wheelDriveName = wheelDrive.getName();
		this.description = wheelDrive.getDescription();
		this.wheelDrivePrice = wheelDrive.getPrice();
		this.wheelDriveImage = wheelDrive.getImage().getUrl();
	}

	public static WheelDriveResponse from(WheelDrive wheelDrive) {
		return new WheelDriveResponse(wheelDrive);
	}
}
