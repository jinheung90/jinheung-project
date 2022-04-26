package com.jinheung.product.domain.product.es.repository;

import com.jinheung.product.domain.product.es.entity.ProductInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductInfoRepository extends ElasticsearchRepository<String, ProductInfo> {
}
