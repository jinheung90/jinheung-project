package com.jinheung.project.domain.order.mongo.doc;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
@Document( collection = "payment_logs")
@Builder
@Getter
public class PaymentLog {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field("imp_uid")
    private String impUid;
    @Field(name = "user_id")
    private Long userId;
    @Field(name = "product_id")
    private String productId;
    @Field
    private Integer status;
    @Field
    private String reason;
    @Field(name = "created_at")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDateTime updatedAt;

}
