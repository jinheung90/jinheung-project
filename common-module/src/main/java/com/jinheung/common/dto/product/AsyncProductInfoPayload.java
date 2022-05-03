package com.jinheung.common.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsyncProductInfoPayload {
    private Long productId;
    private Integer price;
    private Integer stock;
    private String name;
    private String detail;
}
