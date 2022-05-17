package com.jinheung.project.domain.product.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.IdMessagePayload;
import com.jinheung.common.dto.product.AsyncProductInfoPayload;
import com.jinheung.common.dto.product.OrderVerifyPayload;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.project.domain.product.es.entity.ProductInfo;
import com.jinheung.project.domain.product.es.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE;
import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductInfoListener {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO)
    public void productUpdate(@Payload String data) {
        AsyncProductInfoPayload asyncProductInfoPayload =
            new Gson().fromJson(data, AsyncProductInfoPayload.class);
        ProductInfo productInfo = productInfoService.findByIdAndUpdate(
            asyncProductInfoPayload.getProductId(),
            asyncProductInfoPayload.getName(),
            asyncProductInfoPayload.getDetail(),
            asyncProductInfoPayload.getStock(),
            asyncProductInfoPayload.getPrice(),
            asyncProductInfoPayload.getActivity());
        kafkaTemplate.send(MsaEvents.KAFKA_CLIENT_PROXY, "success update product");
    }

}
