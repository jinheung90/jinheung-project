package com.jinheung.project.domain.order.dto;

import com.jinheung.common.dto.product.ProductInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    List<ProductInfoDto> productInfoDtoList;
}
