package com.maketit.maketit_orders.jpaTest;

import com.maketit.maketit_orders.MarketitOrdersApplication;
import com.maketit.maketit_orders.orders.dto.OrderResponseDto;
import com.maketit.maketit_orders.orders.repository.OrderQueryRepository;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MarketitOrdersApplication.class)
@Transactional
public class QuerydslTest {

    @Autowired private OrderQueryRepository orderQueryRepository;

    @Test
    void querydsl_주문조회() {
        Long orderId = 1L;
        OrderResponseDto orderResponseDto = orderQueryRepository.findByOrderId(orderId);
        assertNotNull(orderResponseDto);
        log.info("dto: {}", orderResponseDto);

    }
}
