package com.jinheung.project.domain.user.controller;


import com.jinheung.common.dto.auth.ParsedUserDataByJwtToken;
import com.jinheung.project.auth.TokenProvider;
import com.jinheung.project.domain.user.entity.Authority;
import com.jinheung.project.domain.user.entity.User;
import com.jinheung.project.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class UserController {

    private final TokenProvider tokenProvider;
    private final UserService userService;

    @GetMapping("/user/token/verify")
    public ResponseEntity<ParsedUserDataByJwtToken> getUserAuthority(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String bearerToken
    ) {

        if(bearerToken == null || bearerToken.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        if (!StringUtils.hasText(bearerToken) || !bearerToken.startsWith("Bearer ")) {
            return ResponseEntity.ok(null);
        }
        log.info("test");

        bearerToken = bearerToken.substring(7);

        ParsedUserDataByJwtToken parsedUserDataByJwtToken
            = tokenProvider.getUserIdAndAuthorityByJwtAccessToken(bearerToken);
        return ResponseEntity.ok(parsedUserDataByJwtToken);
    }

    @GetMapping("/user/token/test/{id}")
    public ResponseEntity<String> testTokenProvider(
        @PathVariable(name = "id") Long id
    ) {
        String token = tokenProvider.createJwtAccessTokenByUser(User.builder().id(id)
            .authorities(new ArrayList<>() {{
                add(new Authority("ROLE_USER"));
            }}).build());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/user/token/{id}")
    public ResponseEntity<String> getTokenById(
        @PathVariable(name = "id") Long id
    ) {
        String token = tokenProvider.createJwtAccessTokenByUser(
            userService.findByUserId(id));
        return ResponseEntity.ok(token);
    }



}
