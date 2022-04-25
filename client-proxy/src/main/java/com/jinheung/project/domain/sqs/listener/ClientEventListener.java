package com.jinheung.project.domain.sqs.listener;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.jinheung.project.domain.user.redis.repository.UserSessionRepository;
import com.jinheung.project.domain.user.redis.service.UserSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientEventListener {
    private final SimpMessagingTemplate messagingTemplate;
    private final UserSessionService userSessionService;
    private final AmazonSQSAsync amazonSQSAsync;


    @SqsListener(value = "client-proxy", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    private void receiveMessage(String message, @Header("userId") String userId) {
        log.info("test");
        messagingTemplate.convertAndSendToUser(
            userSessionService.findByUserId(userId),
            "/event",
            message
        );
    }
}
