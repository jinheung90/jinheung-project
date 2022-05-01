package com.jinheung.project.domain.product.es.repository;


import com.jinheung.project.domain.product.es.entity.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
@RequiredArgsConstructor
public class ProductInfoQuery {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public SearchHits<ProductInfo> searchProductByQuery(String query, Pageable pageable) {
        Query searchQuery = new NativeSearchQueryBuilder()
            .withQuery(boolQuery().should(termsQuery("name", query)).boost(2.f))
            .withQuery(boolQuery().should(termsQuery("detail", query)))
            .withFilter(matchQuery("activity",true))
            .withSort(SortBuilders.fieldSort("updatedAt").order(SortOrder.DESC))
            .withPageable(pageable)
            .build();

        return elasticsearchRestTemplate.search(searchQuery, ProductInfo.class, IndexCoordinates.of("mentor_profiles"));
    }
}
