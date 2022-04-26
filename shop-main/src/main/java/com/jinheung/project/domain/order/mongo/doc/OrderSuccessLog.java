package com.jinheung.project.domain.order.mongo.doc;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;

@Document( collection = "order_success_log")
@Builder
@Getter // 추후에 universities라는 곳에 편입 될예정
public class OrderSuccessLog {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Field(name = "pay_success")
    private String paySuccess;
    @Field(name = "stock_success")
    private String stockSuccess;

    @Field(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDateTime updatedAt;
}
