package com.jinheung.product.domain.product.es.service;

import com.jinheung.common.dto.payment.PaymentKafkaDto;
import com.jinheung.common.dto.product.OrderVerifyPayload;

import com.jinheung.product.domain.product.es.entity.ProductInfo;
import com.jinheung.product.domain.product.es.repository.ProductInfoQuery;
import com.jinheung.product.domain.product.es.repository.ProductInfoRepository;
import com.jinheung.product.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_FAILURE;

@Service
@RequiredArgsConstructor
public class ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
    private final ProductInfoQuery productInfoQuery;
    private final KafkaTemplate<String, PaymentKafkaDto> kafkaTemplate;


    public SearchPage<ProductInfo> searchProduct(String query, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        SearchHits<ProductInfo> result = productInfoQuery.searchProductByQuery(query, pageable);
        return SearchHitSupport.searchPageFor(result, pageable);
    }

    public ProductInfo findByIdAndUpdate(String id, Integer reduceCount, String orderId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findFirstByActivityIsTrueAndId(id);
        if(productInfoOptional.isPresent()) {
            ProductInfo productInfo = productInfoOptional.get();
            productInfo.reduceProduct(reduceCount);
            return productInfoRepository.save(productInfo);
        }
        return null;
    }


}
