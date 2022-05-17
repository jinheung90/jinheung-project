package com.jinheung.project.domain.order.service;

import com.google.gson.Gson;
import com.jinheung.common.dto.client.FromOrderPayload;

import com.jinheung.common.dto.product.OrderVerifyPayload;

import com.jinheung.common.event.MsaEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_CANCEL_PAYMENT;
import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE;

@Component
@RequiredArgsConstructor
public class OrderFailureKafkaListener {
    private final KafkaTemplate<String, FromOrderPayload> template;
    private final PaymentService paymentService;

//    @KafkaListener(topics = KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE)
//    public void onOrderFailure(@Payload OrderVerifyPayload data) {
//        template.send(MsaEvents.KAFKA_ORDER_CLIENT_PROXY, new FromOrderPayload(
//            data.getUserId(),data.getOrderId(),data.getMessage()
//        ));
//        paymentService.saveFailureOrderEvent(data.getOrderId(), data.getMessage());
//    }
//
//    @KafkaListener(topics = KAFKA_TOPIC_CANCEL_PAYMENT)
//    public void onCancelPayment(@Payload OrderVerifyPayload data) {
//        template.send(MsaEvents.KAFKA_ORDER_CLIENT_PROXY, new FromOrderPayload(
//            data.getUserId(),data.getOrderId(),data.getMessage()
//        ));
//        paymentService.saveFailureOrderEvent(data.getOrderId(), data.getMessage());
//    }
}
