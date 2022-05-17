package com.jinheung.project.domain.order.dto;


import com.jinheung.common.dto.product.OrderHasProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class OrderRequest {
    @NotNull
    private String impUid;
    @NotNull
    private Set<OrderHasProductDto> orderHasProducts;
}
