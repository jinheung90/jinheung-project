package com.jinheung.project.domain.order.controller;

import com.jinheung.project.domain.order.dto.OrderRequest;
import com.jinheung.project.domain.order.mongo.doc.OrderEvent;
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

    @PostMapping("/order/verify")
    public ResponseEntity getUserAuthority(
        @RequestBody OrderRequest orderRequest,
        @RequestHeader(name = ACCESS_TOKEN_HEADER) String jwt,
        @RequestHeader(name = USER_ID) Long userId
        ) {
        Payment payment = paymentService.verifyPayment(
            userId,
            orderRequest.getProductId(),
            orderRequest.getImpUid(),
            orderRequest.getQuantity(),
            orderRequest.getPrice()
        );

        orderKafkaPublisher.orderPublish(
            orderRequest.getImpUid(),
            orderRequest.getProductId(),
            orderRequest.getQuantity(),
            userId,
            orderRequest.getPrice()
        );
        return ResponseEntity.ok("get ");
    }

    @GetMapping("/order/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("B");
    }

}
