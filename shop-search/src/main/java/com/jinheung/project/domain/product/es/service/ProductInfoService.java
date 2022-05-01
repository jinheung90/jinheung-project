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

    public ProductInfo findByIdAndUpdate(String id, Integer reduceCount, String orderId) {
//        Optional<ProductInfo> productInfoOptional = productInfoRepository.findFirstByActivityIsTrueAndId(id);
//        if(productInfoOptional.isPresent()) {
//            ProductInfo productInfo = productInfoOptional.get();
//            productInfo.reduceProduct(reduceCount);
//            return productInfoRepository.save(productInfo);
//        }
        return null;
    }


}
