package com.jinheung.project.clients;

import com.jinheung.common.dto.ParsedUserDataByJwtToken;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@RequiredArgsConstructor
@Component
public class UserResourceServiceImpl {

    private final UserResourceService userResourceService;

    public ResponseEntity<String> getTokenByRefresh(
        String bearerToken) {
        return userResourceService.getTokenByRefresh(bearerToken);
    }
//
//    public ResponseEntity<ParsedUserDataByJwtToken> verifyToken(
//        @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken);

}
