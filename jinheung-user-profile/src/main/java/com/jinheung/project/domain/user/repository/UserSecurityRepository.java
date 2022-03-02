package com.jinheung.project.domain.user.repository;

import com.jinheung.project.domain.user.entity.UserSecurity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
//    UserSecurity findByUser_Id(long userId);
}
