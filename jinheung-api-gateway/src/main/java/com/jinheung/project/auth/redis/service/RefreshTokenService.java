package com.jinheung.project.auth.redis.service;

import com.jinheung.project.auth.redis.entity.RefreshTokenData;
import com.jinheung.project.auth.redis.repository.RefreshTokenDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenDataRepository refreshTokenDataRepository;
    public Mono<RefreshTokenData> findById(String id) {
        return refreshTokenDataRepository.findById(id);
    }
}
