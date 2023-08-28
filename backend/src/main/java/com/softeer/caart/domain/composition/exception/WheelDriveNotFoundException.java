package com.softeer.caart.domain.composition.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class WheelDriveNotFoundException extends BusinessException {
	public WheelDriveNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
