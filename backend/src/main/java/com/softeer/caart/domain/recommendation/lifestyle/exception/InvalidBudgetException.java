package com.softeer.caart.domain.recommendation.lifestyle.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class InvalidBudgetException extends BusinessException {
	public InvalidBudgetException(ResultCode resultCode) {
		super(resultCode);
	}
}
