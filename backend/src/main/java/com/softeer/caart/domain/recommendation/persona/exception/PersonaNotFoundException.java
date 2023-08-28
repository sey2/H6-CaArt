package com.softeer.caart.domain.recommendation.persona.exception;

import com.softeer.caart.global.ResultCode;
import com.softeer.caart.global.exception.BusinessException;

public class PersonaNotFoundException extends BusinessException {

	public PersonaNotFoundException(ResultCode resultCode) {
		super(resultCode);
	}
}
