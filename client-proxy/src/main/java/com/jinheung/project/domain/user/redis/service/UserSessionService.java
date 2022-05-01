package com.jinheung.project.domain.user.redis.service;

import com.jinheung.project.domain.user.redis.repository.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSessionService {
    private final UserSessionRepository userSessionRepository;
    public String findByUserId(Long userId) {
        return userSessionRepository.getUserSessionByUserId(userId.toString());
    }

    public void saveUserId(String userId, String sessionUserId) {
        userSessionRepository.setUserSessionByUserId(userId, sessionUserId);
    }
}
