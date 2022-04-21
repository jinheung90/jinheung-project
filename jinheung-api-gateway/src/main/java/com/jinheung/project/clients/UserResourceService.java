package com.jinheung.project.clients;

import com.jinheung.common.dto.auth.ParsedUserDataByJwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;



//@FeignClient(name = "user-service")
@Service
public class UserResourceService {
    @Value("${routes.user-service.base-uri}")
    private String baseUri;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        System.out.println(baseUri);
        webClient = WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }

    public Mono<ParsedUserDataByJwtToken> verifyToken(String token) {
        System.out.println(token);
        return webClient.get()
            .uri(baseUri + "/user/token/verify")
            .header(HttpHeaders.AUTHORIZATION, token)
            .retrieve()
            .bodyToMono(ParsedUserDataByJwtToken.class);
    }

    public Mono<String> getTokenById(Long id) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/user/token/{id}").build(id))
            .retrieve()
            .bodyToMono(String.class);
    }
}

