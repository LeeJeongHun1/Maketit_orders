package com.maketit.maketit_orders.utils;

import com.maketit.maketit_orders.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class ApiError {
    public String msg;
    public HttpStatus httpStatus;
    public int httpStatusCode;

    public ApiError(String msg, HttpStatus httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
    }
}
