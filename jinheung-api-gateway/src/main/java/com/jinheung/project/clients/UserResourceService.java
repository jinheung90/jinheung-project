package com.jinheung.project.clients;

import com.jinheung.common.dto.ParsedUserDataByJwtToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
@FeignClient(name = "user-service")
public interface UserResourceService {
    @GetMapping(
        value = "/user/token",
        produces = "application/json")
    ResponseEntity<String> getTokenByRefresh(
        @RequestHeader() String bearerToken);
    @GetMapping(
        value = "/user/token/verify",
        produces = "application/json")
    ResponseEntity<ParsedUserDataByJwtToken> verifyToken(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken);
}

