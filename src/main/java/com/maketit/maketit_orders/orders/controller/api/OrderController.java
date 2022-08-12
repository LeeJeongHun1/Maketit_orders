package com.maketit.maketit_orders.orders.controller.api;

import com.maketit.maketit_orders.exception.CustomException;
import com.maketit.maketit_orders.exception.ErrorCode;
import com.maketit.maketit_orders.orders.dto.OrderRequestDto;
import com.maketit.maketit_orders.orders.dto.OrderResponseDto;
import com.maketit.maketit_orders.orders.service.OrderService;
import com.maketit.maketit_orders.utils.ApiError;
import com.maketit.maketit_orders.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    /**
     * 해당 상품 주문처리
     * @param productId 상품 Id
     * @param orderRequestDto 주문 정보
     * @return
     */
    @PostMapping("/{id}/accept")
    public ResponseEntity accept(@PathVariable("id") Long productId,
                                 @RequestBody OrderRequestDto orderRequestDto) {

        if (orderRequestDto.getEmail() == null) {
            // 인증 관련 로직이 없으므로 email로 대체
            return ResponseEntity.status(HttpStatus.valueOf(ErrorCode.UNAUTHORIZED_USER.getCode()))
                    .body(ApiUtils.error(ErrorCode.UNAUTHORIZED_USER));

        }
        return ResponseEntity.ok(ApiUtils.success(orderService.orderAccept(productId, orderRequestDto)));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity complete(@PathVariable("id") Long orderId,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        if (orderRequestDto.getEmail() == null) {
            // 인증 관련 로직이 없으므로 email로 대체
            return ResponseEntity.status(HttpStatus.valueOf(ErrorCode.UNAUTHORIZED_USER.getCode()))
                    .body(ApiUtils.error(ErrorCode.UNAUTHORIZED_USER));

        }
        return ResponseEntity.ok(ApiUtils.success(orderService.orderComplete(orderId)));
    }

    /**
     * 주문 Id에 해당하는 주문내역
     * @param orderId orderId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity order(@PathVariable("id") Long orderId,
                                @RequestBody OrderRequestDto orderRequestDto) {
        if (orderRequestDto.getEmail() == null) {
            // 인증 관련 로직이 없으므로 email로 대체
            return ResponseEntity.status(HttpStatus.valueOf(ErrorCode.UNAUTHORIZED_USER.getCode()))
                    .body(ApiUtils.error(ErrorCode.UNAUTHORIZED_USER));

        }
        return ResponseEntity.ok(ApiUtils.success(orderService.order(orderId)));
    }

    /**
     * 요청한 주문자의 전체 주문내역
     * @return
     */
    @GetMapping("/")
    public ResponseEntity orderHistory(@RequestBody OrderRequestDto orderRequestDto) {
        if (orderRequestDto.getEmail() == null) {
            // 인증 관련 로직이 없으므로 email로 대체
            return ResponseEntity.status(HttpStatus.valueOf(ErrorCode.UNAUTHORIZED_USER.getCode()))
                    .body(ApiUtils.error(ErrorCode.UNAUTHORIZED_USER));

        }

        return ResponseEntity.ok(ApiUtils.success(orderService.orderAll(orderRequestDto.getEmail())));
    }
}
