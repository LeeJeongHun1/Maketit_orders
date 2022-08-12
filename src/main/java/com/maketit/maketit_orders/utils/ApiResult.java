package com.maketit.maketit_orders.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResult<T> {

    private boolean success;
    private T response;
    public ApiError apiError;

}
