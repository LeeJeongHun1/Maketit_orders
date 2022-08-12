package com.maketit.maketit_orders.exception;

import com.maketit.maketit_orders.utils.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity customException(CustomException e) {
        return ResponseEntity.status(HttpStatus.valueOf(e.getErrorCode().getCode()))
                .body(ApiUtils.error(e.getErrorCode()));
    }
}
