package com.jinheung.project.domain.user.repository;

import com.jinheung.project.domain.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    boolean existsByAuthorityName(String role);
}
