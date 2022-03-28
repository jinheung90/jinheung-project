package com.jinheung.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class MsaEvents {
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE = "/product/reduce-stock";
    public static final String KAFKA_TOPIC_PAYMENT = "/payment";
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_SUCCESS = "/product/reduce-stock/success";
    public static final String KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE = "/order/failure";
    private String topic;
}
