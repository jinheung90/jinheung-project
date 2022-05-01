package com.jinheung.common.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FromOrderPayload {
    private Long userId;
    private String orderId;
    private String message;
}
