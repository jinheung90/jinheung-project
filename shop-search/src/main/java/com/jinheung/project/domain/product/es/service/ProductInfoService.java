package com.jinheung.project.domain.product.es.service;

import com.jinheung.common.dto.payment.PaymentKafkaDto;

import com.jinheung.project.domain.product.es.entity.ProductInfo;
import com.jinheung.project.domain.product.es.repository.ProductInfoQuery;
import com.jinheung.project.domain.product.es.repository.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
    private final ProductInfoQuery productInfoQuery;



    public SearchPage<ProductInfo> searchProduct(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        SearchHits<ProductInfo> result = productInfoQuery.searchProductByQuery(query, pageable);
        return SearchHitSupport.searchPageFor(result, pageable);
    }

    public ProductInfo findByIdAndUpdate(
        Long productId,
        String name,
        String detail,
        Integer stock,
        Integer price,
        Boolean activity) {

        ProductInfo productInfo = productInfoRepository.findFirstByProductId(productId);
        if(productInfo == null) {
            return productInfoRepository.save(
                ProductInfo.builder()
                    .productId(productId)
                    .name(name)
                    .detail(detail)
                    .stock(stock)
                    .price(price)
                    .build());
        } else {
            productInfo.setProductId(productId);
            productInfo.setName(name);
            productInfo.setDetail(detail);
            productInfo.setPrice(price);
            productInfo.setStock(stock);
            productInfo.setActivity(activity);
            return productInfoRepository.save(productInfo);
        }

    }


}
