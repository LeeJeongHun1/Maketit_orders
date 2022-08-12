//package com.maketit.maketit_orders.orders.domain;
//
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.maketit.maketit_orders.product.domain.Product;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@SequenceGenerator(
//        name = "ORDER_ITEM_SEQ_GENERATOR",
//        sequenceName = "SEQ_ORDER_ITEM",
//        initialValue = 1, allocationSize = 1)
//@Entity(name = "TB_ORDER_ITEM")
//public class OrderItem extends DateEntity{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ_GENERATOR")
//    private Long orderItemId;
//
//    @Column(nullable = false)
//    private Long orderPrice;
//
//    @Column(nullable = false)
//    private Long count;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "productId")
//    @JsonBackReference
//    private Product product;
//
//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderId")
//    @JsonBackReference
//    private Order order;
//
//
//
//
//
//}
