package com.jinheung.project.domain.order.jpa.repository;


import com.jinheung.project.domain.order.jpa.entity.Order;
import com.jinheung.project.domain.order.jpa.entity.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Long> {
}
