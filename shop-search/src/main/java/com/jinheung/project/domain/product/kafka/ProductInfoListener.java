package com.jinheung.project.domain.product.kafka;

import com.jinheung.common.dto.product.OrderVerifyPayload;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.project.domain.product.es.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE;

@Component
@RequiredArgsConstructor
public class ProductInfoListener {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, OrderVerifyPayload> template;

    @KafkaListener(topics = KAFKA_TOPIC_PRODUCT_STOCK_REDUCE)
    public void reduceStockProductCount(@Payload OrderVerifyPayload data) {
        if(productInfoService.findByIdAndUpdate(data.getProductId(), data.getReduceCount(), data.getOrderId()) != null) {
            template.send(MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_FAILURE, data);
        }
    }
}
