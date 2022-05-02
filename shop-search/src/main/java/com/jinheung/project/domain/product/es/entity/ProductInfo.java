package com.jinheung.project.domain.product.es.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products_infos")
@Setting(settingPath = "es/setting/nori.json")
public class ProductInfo {

    @Id
    private String Id;

    @Field
    private String name;

    @Field
    private String detail;

    @Field
    private Integer price;

    @Field(name = "create_at")
    private Date createdAt;

    @Field(name = "updated_at")
    private Date updatedAt;

    @Field
    private Integer stock;

    @Field
    private Boolean activity;

    public void reduceProduct(int reduce) {
        stock -= reduce;
    }
}
