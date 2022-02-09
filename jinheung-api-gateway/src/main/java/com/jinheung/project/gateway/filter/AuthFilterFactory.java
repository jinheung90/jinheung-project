package com.jinheung.project.gateway.filter;

import com.jinheung.project.auth.TokenProvider;


import com.jinheung.project.auth.dto.ParsedUserDataByJwtToken;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

//@Component
//@Slf4j
//public class AuthFilterFactory extends AbstractGatewayFilterFactory<AuthFilterFactory.Config> {
//
//    private TokenProvider tokenProvider;
//    public AuthFilterFactory(TokenProvider tokenProvider) {
//        super(AuthFilterFactory.Config.class);
//        this.tokenProvider = tokenProvider;
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//
//        return (exchange, chain) -> {
//
//            ServerHttpRequest request = exchange.getRequest();
//            String token = resolveToken(request);
//
//            if(StringUtils.hasText(token)) {
//                log.info(config.getUserIdHeaderName());
//                ParsedUserDataByJwtToken tokenData = tokenProvider.getUserIdAndAuthorityByJwtAccessToken(token);
//                if(tokenData != null)  {
//                    log.info(tokenData.getUserId().toString());
//                    request.mutate().header(config.getUserIdHeaderName(), tokenData.getUserId().toString());
//                    request.mutate().header(config.getUserRoleHeaderName(), tokenData.getAuthorities().toArray(String[]::new));
//                }
//            }
//            return chain.filter(exchange.mutate().request(request).build());
//        };
//    }
//
//
//    @Getter
//    public static class Config {
//        private final String userRoleHeaderName = "user-role";
//        private final String userIdHeaderName = "user-id";
//    }
//
//    private String resolveToken(ServerHttpRequest request) {
//
//        HttpHeaders headers = request.getHeaders();
//        List<String> token = headers.get(HttpHeaders.AUTHORIZATION);
//
//        if(token == null || token.isEmpty()) {
//            return null;
//        }
//
//        String strToken = token.get(0);
//        if (StringUtils.hasText(strToken) && strToken.startsWith("Bearer ")) {
//            return strToken.substring(7);
//        }
//
//        return null;
//    }
//}
