package com.jinheung.project.domain.order.mongo.doc;


import lombok.Builder;
import lombok.Getter;
import org.mapstruct.ObjectFactory;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;

@Document( collection = "order_events")
@Builder
@Getter
public class OrderEvent {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field("imp_uid")
    private String impUid;
    @Field(name = "user_id")
    private Long userId;
    @Field(name = "product_id")
    private String productId;
    @Field
    private Integer success;
    @Field
    private String reason;
    @Field(name = "stock")
    private Integer stock;
    @Field(name = "price")
    private Integer price;
    @Field(name = "created_at")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setFailure(String reason) {
        this.reason = reason;
        this.success = -1;
    }
}
