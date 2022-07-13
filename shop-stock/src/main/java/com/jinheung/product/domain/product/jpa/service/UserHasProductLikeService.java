package com.jinheung.product.domain.product.jpa.service;

import com.jinheung.product.domain.product.jpa.entity.UserHasProductLike;
import com.jinheung.product.domain.product.jpa.repository.UserHasProductLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserHasProductLikeService {

    private final UserHasProductLikeRepository userHasProductLikeRepository;
    public void saveRandom() {
        for (long i = 1; i < 20000; i++) {
            userHasProductLikeRepository.save(
                UserHasProductLike.builder()
                    .userId(i)
                    .productId(i)
                    .build());

        }

    }
}
