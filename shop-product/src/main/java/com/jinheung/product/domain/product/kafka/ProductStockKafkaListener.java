package com.jinheung.product.domain.product.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.product.domain.product.jpa.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.jinheung.common.dto.product.ReduceStockKafkaData;

@Component
@RequiredArgsConstructor
public class ProductStockKafkaListener {

    private final ProductStockService productStockService;
    private final KafkaTemplate<String, KafkaEventDto> template;

    @KafkaListener(id = "product", topics = MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE)
    public void reduceStockProductCount(KafkaEventDto data) {

        ReduceStockKafkaData reduceStockKafkaData =
            new Gson().fromJson(data.getJsonData(), ReduceStockKafkaData.class);

        ProductStock productStock
            = productStockService.reduceProductStock(
                reduceStockKafkaData.getProductId(),
                reduceStockKafkaData.getReduceCount());

        if(productStock != null) {
            template.send(MsaEvents.KAFKA_TOPIC_PAYMENT,
                    new KafkaEventDto(data.getEventId(), data.getJwtToken(), "success")
                );
        } else {
            template.send(MsaEvents.KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE,
                new KafkaEventDto(data.getEventId(), data.getJwtToken(),  "stock is not enough"));
        }
    }
}
