package com.jinheung.product.domain.product.redis.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@SpringBootTest
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@Tag("integration")
@ActiveProfiles("local")
@TestMethodOrder(value = MethodOrderer.DisplayName.class)

class UserHasProductLikeDataServiceTest {
    @Autowired
    private UserHasProductLikeDataService userHasProductLikeDataService;

    @Test
    @DisplayName("sec check")
    void test1 () {
        int start = LocalDateTime.now().getNano();
        System.out.println(start);
        userHasProductLikeDataService.saveMultipleLike();
        int end = LocalDateTime.now().getNano();
        System.out.println(end - start);
    }
}
