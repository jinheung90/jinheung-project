package com.jinheung.project.domain.product.es.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Document(indexName = "products_infos")
@Setting(settingPath = "es/setting/nori.json")
public class ProductInfo {

    @Id
    @Field
    private String Id;
    @Field(name = "product_id", type = FieldType.Long)
    private Long productId;

    @Field(analyzer = "korean", type = FieldType.Text)
    private String name;

    @Field(analyzer = "korean", type = FieldType.Text)
    private String detail;

    @Field
    private Integer price;

    // localdatetime convert 때문에 deprecated 됬지만 씀
    @Field(type = FieldType.Date, format = DateFormat.custom, name = "created_at", pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    @Field(type = FieldType.Date, format = DateFormat.custom, name = "updated_at", pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime updatedAt;
    @Field
    private Integer stock;

    @Field
    private Boolean activity;

    public void reduceProduct(int reduce) {
        stock -= reduce;
    }

    public void update(String name, String detail, Boolean activity) {
        this.name = Objects.requireNonNullElse(name, this.name);
        this.detail = Objects.requireNonNullElse(detail, this.detail);
        this.activity = Objects.requireNonNullElse(activity, this.activity);
    }
}
