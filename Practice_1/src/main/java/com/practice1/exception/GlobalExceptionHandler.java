package com.practice1.exception;

import com.practice1.response.ApiErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiErrorResponse> handleAppException(AppException ex)  {
        var errorBody = new ApiErrorResponse(ex.getErrorCodeType().getCode(), ex.getErrorCodeType().getMessage());
        return ResponseEntity.status(ex.getErrorCodeType().getStatus()).body(errorBody);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleException(RuntimeException e) {
        var errorBody = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return ResponseEntity.status(errorBody.getCode()).body(errorBody);
    }
}
