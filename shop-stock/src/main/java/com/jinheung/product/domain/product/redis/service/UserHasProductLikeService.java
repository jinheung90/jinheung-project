package com.jinheung.product.domain.product.redis.service;

import com.jinheung.product.domain.product.redis.repository.UserHasProductLikeDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserHasProductLikeService {
    private final UserHasProductLikeDataRepository userHasProductLikeDataRepository;

    public void saveMultipleLike() {
        for (long i = 1; i < 20000; i++) {
            userHasProductLikeDataRepository.addLike(
                i,
                i
            );
        }
    }
}
