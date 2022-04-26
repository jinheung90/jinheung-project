package com.jinheung.project.clients.api;

import com.jinheung.common.dto.auth.ParsedUserDataByJwtToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", url = "${services.user-service}")
public interface UserClient {

    @GetMapping(value = "/user/token/verify", produces = "application/json")
    ResponseEntity<ParsedUserDataByJwtToken> getUserAuthorityByToken(
        @RequestHeader(name = HttpHeaders.AUTHORIZATION) String bearerToken
    );
}
