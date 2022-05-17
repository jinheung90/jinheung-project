package com.jinheung.project.domain.order.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private Long productId;
    private Integer quantity;
}
