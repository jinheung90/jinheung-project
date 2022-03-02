package com.jinheung.project.auth.redis.repository;

import com.jinheung.project.auth.redis.entity.RefreshTokenData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RefreshTokenDataRepository extends CrudRepository<RefreshTokenData, String> {
}
