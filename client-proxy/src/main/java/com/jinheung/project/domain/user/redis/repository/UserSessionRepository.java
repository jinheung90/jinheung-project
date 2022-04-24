package com.jinheung.project.domain.user.redis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class UserSessionRepository {
    private static final String SESSION_PREFIX = "user-session:";
    private final RedisTemplate<String, String> redisTemplate;
    public String getUserSessionByUserId(String userId) {
        return Objects.requireNonNull(redisTemplate.opsForValue().get(SESSION_PREFIX + userId), "");
    }
}
