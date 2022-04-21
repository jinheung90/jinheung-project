package com.jinheung.project.domain.user.service;

import com.jinheung.project.domain.user.entity.User;
import com.jinheung.project.domain.user.repository.UserRepository;
import com.jinheung.project.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.project.errorHandling.errorEnums.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User findByUserId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeExceptionWithCode(GlobalErrorCode.NOT_EXISTS_USER));
    }
}

