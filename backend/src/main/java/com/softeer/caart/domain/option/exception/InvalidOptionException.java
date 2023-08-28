package com.softeer.caart.domain.option.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class InvalidOptionException extends BusinessException {
	public InvalidOptionException(ResultCode resultCode, String message) {
		super(resultCode, message);
	}

	public InvalidOptionException(ResultCode resultCode) {
		super(resultCode);
	}
}
