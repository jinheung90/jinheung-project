package com.jinheung.product.domain.product.redis.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class UserHasProductLikeDataRepository {

    private final RedisTemplate<String, Long> redisTemplate;
    private static final String REDIS_KEY = "USER_HAS_PRODUCT_LIKE:";

    public Set<Long> getByUserId(Long userId) {
        return redisTemplate.opsForSet().members(REDIS_KEY + userId);
    }

    public void addLike(Long userId, Long productId) {
        redisTemplate.opsForHash().put(REDIS_KEY, userId, productId);
    }

    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return redisTemplate.opsForSet().isMember(REDIS_KEY + userId, productId);
    }

}
