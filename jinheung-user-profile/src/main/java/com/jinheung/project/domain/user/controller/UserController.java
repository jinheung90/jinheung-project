package com.jinheung.project.domain.user.controller;


import com.jinheung.project.auth.ParsedUserDataByJwtToken;
import com.jinheung.project.auth.TokenProvider;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class UserController {

    private final TokenProvider tokenProvider;

    @GetMapping("/user/token/verify")
    public ResponseEntity<String> getUserAuthority(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String bearerToken
    ) {

        if(bearerToken == null || bearerToken.isEmpty()) {
            return null;
        }

        if (!StringUtils.hasText(bearerToken) || !bearerToken.startsWith("Bearer ")) {
            return ResponseEntity.ok(null);
        }

        bearerToken = bearerToken.substring(7);

        ParsedUserDataByJwtToken parsedUserDataByJwtToken
            = tokenProvider.getUserIdAndAuthorityByJwtAccessToken(bearerToken);




        return ResponseEntity.ok("get ");
    }
}
