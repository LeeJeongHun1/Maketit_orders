package com.maketit.maketit_orders.orders.dto;

import com.maketit.maketit_orders.constant.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {

    private OrderStatus orderStatus;

    private Long count;
    private Long amount;

    private String purchaser;
    private String phone;
    private String address;
    private String productName;
    private Long productPrice;
    private LocalDateTime createDate;

}
