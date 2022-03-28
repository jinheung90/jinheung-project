package com.jinheung.product.domain.product.jpa.service;

import com.jinheung.product.domain.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.product.domain.product.jpa.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jinheung.product.domain.errorHandling.errorEnums.GlobalErrorCode.NOT_EXISTS_PRODUCT;

@Service
@RequiredArgsConstructor
public class ProductStockService {
    private final ProductStockRepository productStockRepository;

    @Transactional
    public ProductStock reduceProductStock(String productId, Integer reduceCount) {
        ProductStock productStock = productStockRepository.findFirstByProductId(productId);

        if(productStock == null) {
            throw new RuntimeExceptionWithCode(NOT_EXISTS_PRODUCT);
        }

        if(productStock.getStockCount() - reduceCount < 0) {
            return null;
        }
        productStock.setStockCount(productStock.getStockCount() - reduceCount);
        return productStockRepository.save(productStock);
    }
}
