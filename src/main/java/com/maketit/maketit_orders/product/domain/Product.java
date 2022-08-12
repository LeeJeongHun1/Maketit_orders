package com.maketit.maketit_orders.product.domain;


import com.maketit.maketit_orders.orders.domain.DateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "PRODUCT_SEQ_GENERATOR",
        sequenceName = "SEQ_PRODUCT",
        initialValue = 1, allocationSize = 1)
@Entity(name = "TB_PRODUCT")
public class Product extends DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GENERATOR")
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long stock;


    public void stockUpdate(Long quantity) {
        this.stock = this.stock - quantity;
    }
}
