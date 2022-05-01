package com.jinheung.common.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVerifyPayload {
    private String orderId;
    private String productId;
    private Integer reduceCount = 0;
    private Integer price;
    private Long userId;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
