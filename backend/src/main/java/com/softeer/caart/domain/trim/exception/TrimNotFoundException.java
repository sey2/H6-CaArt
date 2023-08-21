package com.softeer.caart.domain.trim.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class TrimNotFoundException extends BusinessException {
	public TrimNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
