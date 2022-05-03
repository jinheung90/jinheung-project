package com.jinheung.product.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInsertRequest {
    private Long productId;
    private Integer price;
    private Integer stock;
    private String name;
    private String detail;
}
