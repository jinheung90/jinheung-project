package com.jinheung.common.dto.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderHasProductDto {
    @NotNull
    private Long productId;
    @NotNull
    private Integer price;
    @NotNull
    private Integer quantity;
}
