package com.jinheung.project.domain.order.jpa.repository;


import com.jinheung.project.domain.order.jpa.entity.CartHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartHasProductRepository extends JpaRepository<CartHasProduct, Long> {
    List<CartHasProduct> findAllByUserIdOrderByCreatedAt(Long userId);
    Boolean existsByUserIdAndId(Long userId,Long id);
    Optional<CartHasProduct> findFirstByUserIdAndId(Long userId, Long id);
}
