package com.jinheung.product.domain.product.jpa.repository;

import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
    ProductStock findFirstByProductId(String productId);
}
