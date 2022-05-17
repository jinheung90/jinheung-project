package com.jinheung.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class MsaEvents {
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE = "product_reduce_stock";
    public static final String KAFKA_TOPIC_PAYMENT = "payment";
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_SUCCESS = "product_reduce_stock_success";
    public static final String KAFKA_TOPIC_CLIENT_PROXY_ORDER_FAILURE = "order_failure";
    public static final String KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_FAILURE = "product_reduce-stock_cancel";
    public static final String KAFKA_TOPIC_SEARCH_STOCK_REDUCE = "search-reduce-stock";
    public static final String KAFKA_TOPIC_SEARCH_ASYNC_PRODUCT_INFO = "save-search-product";
    public static final String KAFKA_CLIENT_PROXY = "client-proxy";
    public static final String KAFKA_ORDER_CLIENT_PROXY = "order-client-proxy";
    public static final String KAFKA_TOPIC_CANCEL_PAYMENT = "pay-cancel";
}
