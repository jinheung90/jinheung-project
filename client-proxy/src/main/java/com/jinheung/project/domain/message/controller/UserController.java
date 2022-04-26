package com.jinheung.project.domain.message.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jinheung.common.dto.auth.ParsedUserDataByJwtToken;
import com.jinheung.project.clients.api.UserClient;
import com.jinheung.project.domain.user.redis.service.UserSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserSessionService userSessionService;
    private final UserClient userClient;

    @MessageMapping("/client/init")
    public void connectClient(
        @Payload String message,
        SimpMessageHeaderAccessor headerAccessor,
        Principal principal) throws JsonProcessingException {
        String token = Objects.requireNonNull(headerAccessor.getNativeHeader(HttpHeaders.AUTHORIZATION)).get(0);
        ParsedUserDataByJwtToken parsedUserDataByJwtToken = userClient.getUserAuthorityByToken(token).getBody();
        assert parsedUserDataByJwtToken != null;
        userSessionService.saveUserId(parsedUserDataByJwtToken.getUserId().toString(), principal.getName());
    }

}
