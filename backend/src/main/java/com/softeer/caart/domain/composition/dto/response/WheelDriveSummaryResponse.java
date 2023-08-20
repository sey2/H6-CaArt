package com.softeer.caart.domain.composition.dto.response;

import com.softeer.caart.domain.composition.entity.WheelDrive;

import lombok.Getter;

@Getter
public class WheelDriveSummaryResponse {
	private final Long wdId;
	private final String wdName;

	private WheelDriveSummaryResponse(WheelDrive wd) {
		this.wdId = wd.getId();
		this.wdName = wd.getName();
	}

	public static WheelDriveSummaryResponse from(WheelDrive wd) {
		return new WheelDriveSummaryResponse(wd);
	}
}
