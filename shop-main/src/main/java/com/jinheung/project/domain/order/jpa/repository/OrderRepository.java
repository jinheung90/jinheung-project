package com.jinheung.project.domain.order.jpa.repository;


import com.jinheung.project.domain.order.jpa.entity.CartHasProduct;
import com.jinheung.project.domain.order.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
