package com.jinheung.project.auth.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "refresh_token", timeToLive = 30)
public class RefreshTokenData {
    @Id
    private String id;
    private String refreshToken;
    private String refreshExpired;
    private Long userId;
}
