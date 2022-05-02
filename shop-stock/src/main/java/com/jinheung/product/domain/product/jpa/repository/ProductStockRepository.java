package com.jinheung.product.domain.product.jpa.repository;

import com.jinheung.product.domain.product.jpa.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductInfo, Long> {
    ProductInfo findFirstByProductId(String productId);
}
