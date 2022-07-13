package com.jinheung.product.domain.product.jpa.repository;

import com.jinheung.product.domain.product.jpa.entity.ProductInfo;
import com.jinheung.product.domain.product.jpa.entity.UserHasProductLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserHasProductLikeRepository extends JpaRepository<UserHasProductLike, Long> {

}
