package com.softeer.caart.domain.composition.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class BodyTypeNotFoundException extends BusinessException {
	public BodyTypeNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
