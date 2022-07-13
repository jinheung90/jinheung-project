package com.jinheung.product.domain.product.jpa.service;

import com.jinheung.common.dto.product.OrderHasProductDto;
import com.jinheung.product.domain.product.jpa.entity.ProductInfo;

import com.jinheung.product.domain.product.jpa.repository.ProductInfoRepository;
import com.jinheung.product.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.product.errorHandling.errorEnums.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
    @Transactional
    public String reduceProductStock(Set<OrderHasProductDto> orderHasProductDtoSet) {
        HashMap<Long, ProductInfo> productInfoMap = new HashMap<>();
        productInfoRepository.findAllByIdIn(
            orderHasProductDtoSet.stream().map(OrderHasProductDto::getProductId).collect(Collectors.toList()))
            .forEach(productInfo -> productInfoMap.put(productInfo.getId(), productInfo));
        Boolean fitAmountWithStock = false;
        orderHasProductDtoSet.forEach(
            orderHasProductDto -> {
                ProductInfo productInfo = productInfoMap.get(orderHasProductDto.getProductId());
            }
        );

        return null;

    }
    public ProductInfo saveProductInfo(
        Long productId,
        String name,
        String detail,
        Integer price,
        Integer stock,
        Boolean activity
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
        productInfo.setActivity(activity);
        return productInfoRepository.save(productInfo);
    }

    public List<ProductInfo> findByIds(List<Long> ids) {
        return productInfoRepository.findAllByIdIn(ids);
    }
}
