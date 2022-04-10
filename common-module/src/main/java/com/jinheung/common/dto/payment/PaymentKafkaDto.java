package com.jinheung.common.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentKafkaDto {
    private String productId;
    private String orderId;
    private Integer quantity;
    private Integer price;
}
