package com.jinheung.common.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVerifyPayload {
    private String impUid;
    private Set<OrderHasProductDto> orderHasProductDtoList;
    private Long userId;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}
