package com.jinheung.product.domain.product.es.repository;

import com.jinheung.product.domain.product.es.entity.ProductInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ProductInfoRepository extends ElasticsearchRepository<ProductInfo , String> {
    Optional<ProductInfo> findFirstByActivityIsTrueAndId(String id);
}
