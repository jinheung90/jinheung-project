package com.jinheung.project.domain.user.repository;

import com.jinheung.project.domain.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


}
