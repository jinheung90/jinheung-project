package com.jinheung.project.domain.product.es.repository;

import com.jinheung.project.domain.product.es.entity.ProductInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ProductInfoRepository extends ElasticsearchRepository<ProductInfo, String> {
//    Optional<ProductInfo> findFirstByActivityIsTrueAndId(String id);
    ProductInfo findFirstByProductId(Long id);
}
