package com.jinheung.product.domain.product.kafka;


import com.jinheung.common.dto.product.OrderVerifyPayload;
import com.jinheung.common.dto.search.AsyncStockPayload;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.jpa.entity.ProductStock;
import com.jinheung.product.domain.product.jpa.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import static com.jinheung.common.event.MsaEvents.*;

@Component
@RequiredArgsConstructor
public class ProductStockKafkaListener {

    private final ProductStockService productStockService;
    private final KafkaTemplate<String, OrderVerifyPayload> template;
    private final KafkaTemplate<String, AsyncStockPayload> toSearchTemplate;
    private final static String STOCK_IS_EMPTY = "stock is empty";
    private final static String PRICE_IS_NOT_EQ = "payed price not equal stock price";

    @KafkaListener(topics = KAFKA_TOPIC_PRODUCT_STOCK_REDUCE)
    public void reduceStockProductCount(@Payload OrderVerifyPayload data) {

        ProductStock productStock
            = productStockService.reduceProductStock(
            data.getProductId(),
            data.getReduceCount());
        if(productStock == null) {
            data.setMessage(STOCK_IS_EMPTY);
            template.send(KAFKA_TOPIC_CANCEL_PAYMENT, data);
            return;
        }

        if(!productStock.getPrice().equals(data.getPrice())) {
            data.setMessage(PRICE_IS_NOT_EQ);
            template.send(KAFKA_TOPIC_CANCEL_PAYMENT, data);
            return;
        }

        toSearchTemplate.send(KAFKA_TOPIC_SEARCH_STOCK_REDUCE, new AsyncStockPayload(
            data.getProductId(), productStock.getStockCount()
        ));

    }
}
