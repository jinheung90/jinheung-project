package com.jinheung.common.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StockReductionResponse {
    private int leftStockCount;
    private boolean success;
    private Long productId;
}
