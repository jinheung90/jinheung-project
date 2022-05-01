package com.jinheung.product.domain.product.jpa.service;

import com.jinheung.common.event.ClientEventTopics;
import com.jinheung.product.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.product.domain.product.jpa.repository.ProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jinheung.product.errorHandling.errorEnums.GlobalErrorCode.NOT_EXISTS_PRODUCT;

@Service
@RequiredArgsConstructor
public class ProductStockService {
    private final ProductStockRepository productStockRepository;
//    private final KafkaTemplate<String, ClientEventTopics>

    @Transactional
    public ProductStock reduceProductStock(String productId, Integer reduceCount) {
        ProductStock productStock = productStockRepository.findFirstByProductId(productId);

        boolean updateStock = productStock.reduceStock(reduceCount);
        if(updateStock) {
           return productStockRepository.save(productStock);
        }
        return null;
    }
}
