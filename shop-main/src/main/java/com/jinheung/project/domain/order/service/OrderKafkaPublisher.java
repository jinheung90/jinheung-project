package com.jinheung.project.domain.order.service;

import com.google.gson.Gson;
import com.jinheung.common.dto.payment.PaymentKafkaDto;
import com.jinheung.common.dto.product.OrderHasProductDto;
import com.jinheung.common.dto.product.OrderVerifyPayload;

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


import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderKafkaPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public boolean orderPublish(
        String impUid,
        Set<OrderHasProductDto> orderHasProductDtoSet,
        Long userId
     ) {

        kafkaTemplate.send(MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE,
           new Gson().toJson(new OrderVerifyPayload(impUid, orderHasProductDtoSet, userId, ""),
               OrderVerifyPayload.class)
        );

        //iamport로 인해 deprecated
//        paymentKafkaDtoKafkaTemplate.send(MsaEvents.KAFKA_TOPIC_PAYMENT, new PaymentKafkaDto(
//            orderId, productId, quantity, price));

        return true;
    }

}
