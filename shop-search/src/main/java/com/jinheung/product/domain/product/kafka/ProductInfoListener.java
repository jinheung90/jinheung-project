package com.jinheung.product.domain.product.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.product.domain.product.es.service.ProductInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.jinheung.common.dto.product.ReduceStockKafkaData;
import com.jinheung.common.dto.payment.PaymentKafkaDto;

@Component
@RequiredArgsConstructor
public class ProductInfoListener {

    private final ProductInfoService productInfoService;
    private final KafkaTemplate<String, KafkaEventDto> template;


    @KafkaListener(topics = MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_SUCCESS)
    public void reduceStockProductCount(KafkaEventDto data) {

    }
}
