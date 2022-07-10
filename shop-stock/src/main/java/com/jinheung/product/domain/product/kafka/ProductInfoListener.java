package com.jinheung.product.domain.product.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.IdMessagePayload;
import com.jinheung.common.dto.product.AsyncProductInfoPayload;
import com.jinheung.common.dto.product.OrderVerifyPayload;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.jpa.entity.ProductInfo;
import com.jinheung.product.domain.product.jpa.service.ProductInfoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductInfoListener {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE)
    public void reduceStockProductCount(@Payload String data) {
        OrderVerifyPayload orderVerifyPayload =
            new Gson().fromJson(data, OrderVerifyPayload.class);
        String message =
            productInfoService.reduceProductStock(
                orderVerifyPayload.getOrderHasProductDtoList());
        if(message.equals("success")) {
            kafkaTemplate.send(MsaEvents.KAFKA_TOPIC_SEARCH_STOCK_REDUCE,
               new Gson().toJson(
                   orderVerifyPayload.getOrderHasProductDtoList().stream()
                       .map(p -> new IdMessagePayload(p.getProductId(), p.getQuantity().toString()))
                       .collect(Collectors.toList())
               ));
        } else {
            kafkaTemplate.send(MsaEvents.KAFKA_TOPIC_CANCEL_PAYMENT,
                new Gson().toJson(
                    orderVerifyPayload.getOrderHasProductDtoList().stream()
                        .map(p -> new IdMessagePayload(p.getProductId(), p.getQuantity().toString()))
                        .collect(Collectors.toList())
                ));
        }
    }
}
