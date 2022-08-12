package com.maketit.maketit_orders.product.repository;

import com.maketit.maketit_orders.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
