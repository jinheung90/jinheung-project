package com.jinheung.project.domain.signal.message.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    @MessageMapping("/stream")
    public void getData() {

    }
}
