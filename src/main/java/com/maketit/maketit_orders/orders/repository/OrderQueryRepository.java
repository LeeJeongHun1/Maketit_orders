package com.maketit.maketit_orders.orders.repository;

import com.maketit.maketit_orders.orders.dto.OrderResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.maketit.maketit_orders.orders.domain.QOrder.order;


@RequiredArgsConstructor
@Repository
public class OrderQueryRepository {
    private final JPAQueryFactory queryFactory;

    public OrderResponseDto findByOrderId(Long orderId) {
        return queryFactory.select(Projections.fields(OrderResponseDto.class,
                        order.account.name.as("purchaser"),
                        order.account.phone.as("phone"),
                        order.account.address.as("address"),
                        order.product.name.as("productName"),
                        order.product.price.as("productPrice"),
                        order.orderStatus.as("orderStatus"),
                        order.count,
                        order.amount,
                        order.createDate)
                ).from(order)
                .join(order.account)
                .join(order.product)
                .where(order.orderId.eq(orderId))
                .fetchOne();
    }


    public List<OrderResponseDto> findAll(String email) {
        return queryFactory.select(Projections.fields(OrderResponseDto.class,
                        order.account.name.as("purchaser"),
                        order.account.phone.as("phone"),
                        order.account.address.as("address"),
                        order.product.name.as("productName"),
                        order.product.price.as("productPrice"),
                        order.orderStatus.as("orderStatus"),
                        order.count,
                        order.amount,
                        order.createDate)
                ).from(order)
                .join(order.account)
                .join(order.product)
                .where(order.account.email.eq(email))
                .fetch();
    }
}
