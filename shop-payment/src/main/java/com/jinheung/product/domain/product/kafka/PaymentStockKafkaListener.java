package com.jinheung.product.domain.product.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.common.dto.payment.PaymentKafkaDto;
import com.jinheung.common.event.MsaEvents;

import com.jinheung.product.domain.product.jpa.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.jinheung.common.dto.product.ReduceStockKafkaData;

@Component
@RequiredArgsConstructor
public class PaymentStockKafkaListener {

    private final PaymentService paymentService;
    private final KafkaTemplate<String, KafkaEventDto> template;

    @KafkaListener(id = "payment", topics = MsaEvents.KAFKA_TOPIC_PAYMENT)
    public void payment(@Payload KafkaEventDto data) {
        PaymentKafkaDto paymentKafkaDto = new Gson().fromJson(data.getJsonData(), PaymentKafkaDto.class);

    }
}
