package com.maketit.maketit_orders.orders.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maketit.maketit_orders.account.domain.Account;
import com.maketit.maketit_orders.constant.OrderStatus;
import com.maketit.maketit_orders.orders.dto.OrderRequestDto;
import com.maketit.maketit_orders.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "SEQ_ORDER",
        initialValue = 1, allocationSize = 1)
@Entity(name = "TB_ORDER")
public class Order extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    private Long orderId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public void changeStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


}
