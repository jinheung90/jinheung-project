package com.jinheung.project.domain.order.service;

import com.google.gson.Gson;
import com.jinheung.common.dto.payment.PaymentKafkaDto;
import com.jinheung.common.dto.product.ReduceStockKafkaData;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;
import com.jinheung.common.event.MsaEvents;
import com.jinheung.common.dto.kafka.KafkaEventDto;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderKafkaPublisher {

    private final KafkaTemplate<String, KafkaEventDto> kafkaTemplate;

    public boolean orderPublish(
        String jwt,
        String userId,
        String productId,
        Integer quantity,
        Integer price) {

        UUID id = UUID.randomUUID();
        kafkaTemplate.send(MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE,
            new KafkaEventDto(
            id.toString(), jwt,
            new Gson().toJson(
                new ReduceStockKafkaData(productId, quantity),
                ReduceStockKafkaData.class)
        ));

        kafkaTemplate.send(MsaEvents.KAFKA_TOPIC_PAYMENT, new KafkaEventDto(
            id.toString(),jwt, new Gson().toJson(
                new PaymentKafkaDto(
                    userId,
                    productId,
                    quantity,
                    price))
        ));

        return true;
    }

}
