package com.maketit.maketit_orders.orders.service;

import com.maketit.maketit_orders.account.domain.Account;
import com.maketit.maketit_orders.account.repository.AccountRepository;
import com.maketit.maketit_orders.constant.OrderStatus;
import com.maketit.maketit_orders.exception.CustomException;
import com.maketit.maketit_orders.exception.ErrorCode;
import com.maketit.maketit_orders.orders.domain.Order;
import com.maketit.maketit_orders.orders.dto.OrderRequestDto;
import com.maketit.maketit_orders.orders.dto.OrderResponseDto;
import com.maketit.maketit_orders.orders.repository.OrderQueryRepository;
import com.maketit.maketit_orders.orders.repository.OrderRepository;
import com.maketit.maketit_orders.product.domain.Product;
import com.maketit.maketit_orders.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final OrderQueryRepository orderQueryRepository;

    /**
     * 해당 상품이 실제 존재하는지 조회,
     * 해당 상품 주문자가 실제 존재하는지 조회,
     * 해당 상품의 재고 조회
     * 해상 상품의 주문 수량과 총 주문금액 계산
     * 주문 처리 후 재고 변경
     *
     * @param productId       상품 Id
     * @param orderRequestDto 주문관련 client에서 전달받은 data (주문 수량, 주문자 이메일)
     * @return
     */
    @Transactional
    public OrderResponseDto orderAccept(Long productId, OrderRequestDto orderRequestDto) {
        // productId 주문 상품 조회
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new CustomException(ErrorCode.PRODUCT_NOT_FOUND));

        // email 주문 유저 조회
        Account account = accountRepository.findByEmail(orderRequestDto.getEmail()).orElseThrow(() ->
                new CustomException(ErrorCode.USER_NOT_FOUND));

        // 재고 조회
        Long totalPrice = 0L;
        if (product.getStock() < orderRequestDto.getCount()) {
            throw new CustomException(ErrorCode.STOCK_SHORT);
        } else { // 주문 수량 * 상품 가격 => 총 주문 금액
            totalPrice = orderRequestDto.getCount() * product.getPrice();
        }

        // order save 주문 처리
        Order order = Order.builder()
                .product(product)
                .account(account)
                .orderStatus(OrderStatus.waiting)
                .amount(totalPrice)
                .count(orderRequestDto.getCount())
                .build();
        Order savedOrder = orderRepository.save(order);

        // 주문 처리 후 재고 변경
        product.stockUpdate(orderRequestDto.getCount());
        return orderQueryRepository.findByOrderId(savedOrder.getOrderId());
    }

    /**
     * 결제와 같은 주문처리 로직이 정상적으로 끝났다는 가정하에 주문 완료 처리
     *
     * @param orderId 주문 Id
     * @return
     */
    @Transactional
    public OrderResponseDto orderComplete(Long orderId) {
        // 결제와 같은 주문처리 로직이 끝났다는 가정하에 주문 완료
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new CustomException(ErrorCode.NOT_FOUND));

        switch (order.getOrderStatus()) {
            case order:
                throw new CustomException(ErrorCode.ALREADY_ORDER);
            case waiting:
                order.changeStatus(OrderStatus.order);
                break;
            case cancel:
                throw new CustomException(ErrorCode.CANCEL_ORDER);
        }
        return orderQueryRepository.findByOrderId(order.getOrderId());
    }


    @Transactional(readOnly = true)
    public OrderResponseDto order(Long orderId) {
        return orderQueryRepository.findByOrderId(orderId);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> orderAll(String email) {
        return orderQueryRepository.findAll(email);
    }

}
