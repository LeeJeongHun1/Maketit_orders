package com.maketit.maketit_orders.utils;

import com.maketit.maketit_orders.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }


    public static <T> ApiResult<T> error(ErrorCode errorCode) {
        return (ApiResult<T>) new ApiResult<Object>(false, null,
                new ApiError(errorCode.getMessage(), HttpStatus.valueOf(errorCode.getCode())));

    }

}
