package com.maketit.maketit_orders.orders.repository;

import com.maketit.maketit_orders.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
