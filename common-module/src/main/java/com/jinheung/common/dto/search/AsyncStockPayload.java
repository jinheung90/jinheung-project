package com.jinheung.common.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AsyncStockPayload {
    private String productId;
    private Integer stockCount;
}
