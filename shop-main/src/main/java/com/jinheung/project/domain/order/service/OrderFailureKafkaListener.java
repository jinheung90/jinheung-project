package com.jinheung.project.domain.order.service;

import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.common.dto.product.ReduceStockKafkaData;
import com.jinheung.common.event.ClientEventTopics;
import com.jinheung.common.event.MsaEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderFailureKafkaListener {
    private final KafkaTemplate<String, KafkaEventDto> template;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(id = "product", topics = MsaEvents.KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE)
    public void reduceStockProductCount(KafkaEventDto data) {
        simpMessagingTemplate.convertAndSendToUser(
            data.getJwtToken(), ClientEventTopics.ORDER_EVENT_TOPIC,
            data.getJsonData());

    }
}
