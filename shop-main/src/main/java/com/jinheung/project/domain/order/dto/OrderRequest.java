package com.jinheung.project.domain.order.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderRequest {
    private String productId;
    private Integer price;
    private Integer quantity;
    private String impUid;
}
