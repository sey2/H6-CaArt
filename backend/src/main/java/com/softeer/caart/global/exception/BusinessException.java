package com.softeer.caart.global.exception;

import com.softeer.caart.global.ResultCode;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ResultCode resultCode;

    @Builder
    public BusinessException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Builder
    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }
}
