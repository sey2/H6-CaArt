package com.softeer.caart.domain.composition.dto;

import com.softeer.caart.domain.composition.entity.WheelDrive;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WheelDriveResponse {
	private Long wheelDriveId;
	private String wheelDriveName;
	private String description;
	private String summary;
	private Integer wheelDrivePrice;
	private String wheelDriveImage;

	public WheelDriveResponse(WheelDrive wheelDrive) {
		this.wheelDriveId = wheelDrive.getId();
		this.wheelDriveName = wheelDrive.getName();
		this.description = wheelDrive.getDescription();
		this.summary = wheelDrive.getSummary();
		this.wheelDrivePrice = wheelDrive.getPrice();
		this.wheelDriveImage = wheelDrive.getImage().getUrl();
	}

	public static WheelDriveResponse from(WheelDrive wheelDrive) {
		return new WheelDriveResponse(wheelDrive);
	}
}
