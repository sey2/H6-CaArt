package com.softeer.caart.domain.option.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class OptionNotFoundException extends BusinessException {
	public OptionNotFoundException(ResultCode resultCode, String message) {
		super(resultCode, message);
	}

	public OptionNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
