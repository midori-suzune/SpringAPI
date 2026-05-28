package com.practice1.common.enums;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public enum ErrorCodeType {

    USER_NOT_FOUND(1004, "User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS(1005, "User already exists", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus status;
    ErrorCodeType(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
