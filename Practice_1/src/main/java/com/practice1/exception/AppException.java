package com.practice1.exception;

import com.practice1.common.enums.ErrorCodeType;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


public class AppException extends RuntimeException {

    private final ErrorCodeType errorCodeType;

    public AppException(ErrorCodeType errorCodeType) {
        super(errorCodeType.getMessage());
        this.errorCodeType = errorCodeType;
    }

    public ErrorCodeType getErrorCodeType() {
        return errorCodeType;
    }
}
