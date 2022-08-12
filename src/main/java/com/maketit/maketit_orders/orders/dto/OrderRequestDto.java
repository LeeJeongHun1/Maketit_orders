package com.maketit.maketit_orders.orders.dto;

import com.maketit.maketit_orders.account.domain.Account;
import com.maketit.maketit_orders.product.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

    private Long count;
    private String email;



}
