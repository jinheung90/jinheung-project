package com.jinheung.project.domain.user.controller;


import com.jinheung.project.domain.user.redis.service.UserSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
    private final SimpMessagingTemplate messagingTemplate;
    private final UserSessionService userSessionService;
    private QueueMessagingTemplate queueMessagingTemplate;


    @GetMapping("/test1/test")
    private void receiveMessage() {
        log.info("test");

    }
}
