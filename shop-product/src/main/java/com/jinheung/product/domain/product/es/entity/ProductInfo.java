package com.jinheung.product.domain.product.es.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products_infos")
public class ProductInfo {

    @Id
    private String Id;

    @Field
    private String name;

    @Field
    private String detail;

    @Field
    private Integer price;
}
