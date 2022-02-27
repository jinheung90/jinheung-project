package com.jinheung.project.gateway.filter;

import com.jinheung.common.consts.AuthHeaderNames;
import com.jinheung.project.auth.TokenProvider;


import com.jinheung.project.auth.dto.ParsedUserDataByJwtToken;
import com.jinheung.project.auth.redis.service.RefreshTokenService;
import com.jinheung.project.config.RedisConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Slf4j
public class AuthFilterFactory extends AbstractGatewayFilterFactory<AuthFilterFactory.Config> {

//    private final ReactiveRedisTemplate<String, RefreshTokenData> redisTemplate;
    private final RefreshTokenService refreshTokenService;
    private final TokenProvider tokenProvider;
    private static final String REFRESH_REDIS_KEY = "refresh-redis-key";
    private static final String REFRESH_TOKEN_HEADER_NAME = "refresh-token";

    public AuthFilterFactory(TokenProvider tokenProvider,
                             RefreshTokenService refreshTokenService) {
        super(AuthFilterFactory.Config.class);
        this.tokenProvider = tokenProvider;
//        this.redisTemplate = redisTemplate;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();

            HttpHeaders headers = request.getHeaders();
            List<String> headerVal = headers.get(HttpHeaders.AUTHORIZATION);
            String token = resolveToken(headerVal);

            if(StringUtils.hasText(token)) {
                ParsedUserDataByJwtToken tokenData = tokenProvider.getUserIdAndAuthorityByJwtAccessToken(token);
                if(tokenData != null)  {
                    log.info(tokenData.getUserId().toString());
                    request.mutate().header(AuthHeaderNames.USER_ID, tokenData.getUserId().toString());
                    request.mutate().header(AuthHeaderNames.USER_AUTHORITIES,
                        tokenData.getAuthorities().toArray(String[]::new));
                }
            } else {
                List<String> refreshHeaderVal = headers.get(REFRESH_TOKEN_HEADER_NAME);
                if (refreshHeaderVal == null || refreshHeaderVal.isEmpty()) {
                    return chain.filter(exchange.mutate().request(request).build());
                }
                checkRefresh(refreshHeaderVal);
            }
            return chain.filter(exchange.mutate().request(request).build());
        };
    }


    @Getter
    public static class Config {
//        private final String userRoleHeaderName = "user-role";
//        private final String userIdHeaderName = "user-id";
    }

    private String resolveToken(List<String> headerVal) {


        if(headerVal == null || headerVal.isEmpty()) {
            return null;
        }

        String strToken = headerVal.get(0);
        if (StringUtils.hasText(strToken) && strToken.startsWith("Bearer ")) {
            return strToken.substring(7);
        }

        return null;
    }

    private Mono<String> checkRefresh(List<String> refreshHeaderVal) {
        String token = refreshHeaderVal.get(0);
        return refreshTokenService.findById(refreshHeaderVal.get(0))
                .flatMap(refreshTokenData -> {
                    if (refreshTokenData != null) {
                        if(refreshTokenData.getRefreshToken().equals(token) &&
                        LocalDateTime.parse(refreshTokenData.getRefreshExpired(),
                            DateTimeFormatter.ofPattern(RedisConfig.REDIS_TIME_FORMAT)
                            ).isAfter(LocalDateTime.now())) {
                            return Mono.just(tokenProvider.createJwtAccessTokenByUser(null));
                        }
                    }
                    return Mono.empty();
                });
    }
}
