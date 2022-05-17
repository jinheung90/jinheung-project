package com.jinheung.project.domain.order.controller;

import com.jinheung.project.domain.order.dto.OrderRequest;

import com.jinheung.project.domain.order.jpa.entity.Order;
import com.jinheung.project.domain.order.jpa.service.OrderService;
import com.jinheung.project.domain.order.service.OrderKafkaPublisher;

import com.jinheung.project.domain.order.service.PaymentService;
import com.jinheung.project.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

import static com.jinheung.common.consts.AuthHeaderNames.ACCESS_TOKEN_HEADER;
import static com.jinheung.common.consts.AuthHeaderNames.USER_ID;
@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class OrderController {

    private final OrderKafkaPublisher orderKafkaPublisher;
    private final PaymentService paymentService;
    private final OrderService orderService;

    @PostMapping("/order/verify")
    public ResponseEntity getUserAuthority(
        @RequestBody OrderRequest orderRequest,
        @RequestHeader(name = ACCESS_TOKEN_HEADER) String jwt,
        @RequestHeader(name = USER_ID) Long userId
        ) {
        Order order = orderService.saveOrder(orderRequest.getImpUid(), orderRequest.getOrderHasProducts());
        orderKafkaPublisher.orderPublish(orderRequest.getImpUid(), orderRequest.getOrderHasProducts(), userId);
        return ResponseEntity.ok("get ");
    }

    @GetMapping("/order/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("B");
    }


}
