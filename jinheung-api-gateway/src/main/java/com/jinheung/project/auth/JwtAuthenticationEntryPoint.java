package com.jinheung.project.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.jinheung.project.errorHandling.ErrorResponse;
import com.jinheung.project.errorHandling.errorEnums.GlobalErrorCode;
import com.jinheung.project.errorHandling.errorEnums.IErrorCode;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        return sendErrorMessage(exchange.getResponse());
    }

    private Mono<Void> sendErrorMessage(ServerHttpResponse res) {
        res.setStatusCode(HttpStatus.resolve(GlobalErrorCode.NOT_VALID_TOKEN.getStatus())); // 인가 부족 401
        res.getHeaders().add("Content-Type", "application/json");

        byte[] response = null;
        try {
            response = objectMapper.writeValueAsBytes(
                ErrorResponse.responseBody(
                    ((IErrorCode) GlobalErrorCode.NOT_VALID_TOKEN).getCode(),
                    "not valid token",
                    HttpStatus.resolve(((IErrorCode) GlobalErrorCode.NOT_VALID_TOKEN).getStatus())
                ));
        } catch (JsonProcessingException e) {
            response = e.getMessage().getBytes();
        }
        DataBuffer dataBuffer = res.bufferFactory().wrap(response);
        return res.writeWith(Mono.just(dataBuffer));
    }
}
