package com.jinheung.common.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDto {
    private Long productId = null;
    private Integer stockCount;
    private String name;
    private String detail;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductInfoDto fromEntityValues(
        Long productId,
        Integer stockCount,
        String name,
        String detail,
        Integer price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        ProductInfoDto productInfoDto = new ProductInfoDto();
        productInfoDto.productId = productId;
        productInfoDto.stockCount = stockCount;
        productInfoDto.name = name;
        productInfoDto.detail = detail;
        productInfoDto.price = price;
        productInfoDto.createdAt = createdAt;
        productInfoDto.updatedAt = updatedAt;
        return productInfoDto;
    }
}
