package com.softeer.caart.domain.composition.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class EngineNotFoundException extends BusinessException {
	public EngineNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
