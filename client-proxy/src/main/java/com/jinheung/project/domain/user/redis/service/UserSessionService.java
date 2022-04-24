package com.jinheung.project.domain.user.redis.service;

import com.jinheung.project.domain.user.redis.repository.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSessionService {
    private final UserSessionRepository userSessionRepository;
    public String findByUserId(String userId) {
        return userSessionRepository.getUserSessionByUserId(userId);
    }
}
