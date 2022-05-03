package com.jinheung.product.domain.product.jpa.service;

import com.jinheung.product.domain.product.jpa.entity.ProductInfo;

import com.jinheung.product.domain.product.jpa.repository.ProductInfoRepository;
import com.jinheung.product.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.product.errorHandling.errorEnums.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
//    private final KafkaTemplate<String, ClientEventTopics>

    @Transactional
    public ProductInfo reduceProductStock(Long productId, Integer reduceCount) {
        ProductInfo productInfo = productInfoRepository.findById(productId)
            .orElseThrow(() -> new RuntimeExceptionWithCode(GlobalErrorCode.NOT_EXISTS_PRODUCT));

        boolean updateStock = productInfo.reduceStock(reduceCount);
        if(updateStock) {
           return productInfoRepository.save(productInfo);
        }
        return null;
    }
    public ProductInfo saveProductInfo(
        Long productId,
        String name,
        String detail,
        Integer price,
        Integer stock
    ) {
        ProductInfo productInfo = null;
        if(productId == null) {
            productInfo = ProductInfo.builder().build();
        } else {
            productInfo = productInfoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeExceptionWithCode(GlobalErrorCode.NOT_EXISTS_PRODUCT));
        }
        productInfo = Objects.requireNonNullElse(productInfo, ProductInfo.builder().build());
        productInfo.setName(name);
        productInfo.setDetail(detail);
        productInfo.setPrice(price);
        productInfo.setStockCount(stock);
        return productInfoRepository.save(productInfo);
    }
}
