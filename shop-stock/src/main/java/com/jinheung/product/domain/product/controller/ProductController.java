package com.jinheung.product.domain.product.controller;

import com.jinheung.common.dto.product.AsyncProductInfoPayload;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.dto.ProductInsertRequest;
import com.jinheung.product.domain.product.jpa.service.ProductInfoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, AsyncProductInfoPayload> payloadKafkaTemplate;

    @PostMapping("/product")
    public ResponseEntity saveAndUpdateProduct(@RequestBody ProductInsertRequest request) {
        productInfoService.saveProductInfo(
            request.getProductId(),
            request.getName(),
            request.getDetail(),
            request.getPrice(),
            request.getStock()
        );
        payloadKafkaTemplate.send(MsaEvents.KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO,
            new AsyncProductInfoPayload(
                request.getProductId(),
                request.getPrice(),
                request.getStock(),
                request.getName(),
                request.getDetail()
            ));
        return ResponseEntity.ok("");
    }
}
