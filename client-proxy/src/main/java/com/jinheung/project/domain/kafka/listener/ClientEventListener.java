package com.jinheung.project.domain.kafka.listener;

import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.project.domain.user.redis.repository.UserSessionRepository;
import com.jinheung.project.domain.user.redis.service.UserSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.jinheung.common.event.ClientEventTopics.ORDER_EVENT_TOPIC;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientEventListener {

    private final SimpMessagingTemplate messagingTemplate;
    private final UserSessionService userSessionService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = ORDER_EVENT_TOPIC)
    private void receiveMessage(String message) {
        KafkaEventDto kafkaEventDto = new Gson().fromJson(message, KafkaEventDto.class);
        messagingTemplate.convertAndSendToUser(
            userSessionService.findByUserId(kafkaEventDto.getUserId()),
            "/order",
            message
        );
    }

    @GetMapping("/test/test")
    public ResponseEntity test(
        @RequestParam(name = "val") String testVal
    ) {
        kafkaTemplate.send("client-proxy",testVal);
        return ResponseEntity.ok(testVal);
    }
}
