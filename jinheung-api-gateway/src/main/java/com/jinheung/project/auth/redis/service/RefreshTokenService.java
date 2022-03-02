package com.jinheung.project.auth.redis.service;

import com.jinheung.project.auth.redis.entity.RefreshTokenData;
import com.jinheung.project.auth.redis.repository.RefreshTokenDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenDataRepository refreshTokenDataRepository;
    public Mono<RefreshTokenData> findById(String id) {
        return Mono.just(Objects.requireNonNull(refreshTokenDataRepository.findById(id).orElse(null)));
    }
}
