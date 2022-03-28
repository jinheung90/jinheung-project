package com.jinheung.project.domain.order.controller;

import com.jinheung.project.domain.dto.OrderRequest;
import com.jinheung.project.domain.order.service.OrderKafkaPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.jinheung.common.consts.AuthHeaderNames.ACCESS_TOKEN_HEADER;
import static com.jinheung.common.consts.AuthHeaderNames.USER_ID;
@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class OrderController {

    private final OrderKafkaPublisher orderKafkaPublisher;

    @PostMapping("/order")
    public ResponseEntity getUserAuthority(
        @RequestBody OrderRequest orderRequest,
        @RequestHeader(name = ACCESS_TOKEN_HEADER) String jwt,
        @RequestHeader(name = USER_ID) Long userId
        ) {
        orderKafkaPublisher.orderPublish(
            userId.toString(),jwt,
            orderRequest.getProductId(),
            orderRequest.getQuantity(),
            orderRequest.getPrice()
        );
        return ResponseEntity.ok("get ");
    }

}
