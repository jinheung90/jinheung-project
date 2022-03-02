package com.jinheung.project.domain.user.repository;

import com.jinheung.project.domain.user.entity.User;
import com.jinheung.project.domain.user.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    boolean existsByNicknameAndUserIsNot(String nickname, User user);
}
