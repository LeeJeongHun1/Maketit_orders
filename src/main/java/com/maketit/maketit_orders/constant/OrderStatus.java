package com.maketit.maketit_orders.constant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {

    order("order"),
    waiting("waiting"),
    cancel("cancel");

    private final String value;
}
