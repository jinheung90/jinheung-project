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
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_FAILURE = "/product/reduce-stock/cancel";
    public static final String KAFKA_TOPIC_SEARCH_STOCK_REDUCE = "/search/reduce-stock";
    public static final String KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO = "/search/product";
    public static final String KAFKA_CLIENT_PROXY = "/client-proxy";
    public static final String KAFKA_ORDER_CLIENT_PROXY = "/order/client-proxy";
    public static final String KAFKA_TOPIC_CANCEL_PAYMENT = "/pay/cancel";
}
