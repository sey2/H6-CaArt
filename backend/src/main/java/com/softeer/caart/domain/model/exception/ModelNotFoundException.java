package com.softeer.caart.domain.model.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class ModelNotFoundException extends BusinessException {
	public ModelNotFoundException(ResultCode resultCode, String message) {
		super(resultCode, message);
	}

	public ModelNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
