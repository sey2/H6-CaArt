package com.softeer.caart.domain.recommendation.lifestyle.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class InvalidAnswerException extends BusinessException {
	public InvalidAnswerException(ResultCode resultCode) {
		super(resultCode);
	}
}
