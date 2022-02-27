package com.jinheung.project.auth.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "people", timeToLive = 30)
public class RefreshTokenData {
    private String refreshToken;
    private String refreshExpired;
    private Long userId;
}
