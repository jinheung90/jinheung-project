package com.jinheung.payment.domain.payment.jpa.service;

import com.jinheung.payment.domain.payment.enums.PayFailType;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentLog;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentRetry;
import com.jinheung.payment.domain.payment.jpa.repository.PaymentLogRepository;

import com.jinheung.payment.domain.payment.jpa.repository.PaymentRetryRepository;
import com.jinheung.product.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.product.errorHandling.errorEnums.GlobalErrorCode;
import com.mysql.cj.log.Log;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
//
//    @Value("${spring.iamport.name}")
//    private String name;
//
//    @Value("${spring.iamport.pwd")
//    private String pwd;

    private final PaymentLogRepository paymentLogRepository;
    private final PaymentRetryRepository paymentRetryRepository;

    @Transactional
    public PaymentLog pay(String productId, Integer reduceCount, String orderId, Long userId, Integer price) {
        Integer success = this.payMock();
        PaymentLog paymentLog = PaymentLog.builder()
            .payFailType(PayFailType.getState(success))
            .productId(productId)
            .quantity(reduceCount)
            .orderId(orderId)
            .userId(userId)
            .price(price)
            .build();

        if(paymentLog.getPayFailType().equals(PayFailType.PAYMENT_AGENCY_API_ERROR)) {
            saveRetryCount(paymentLog, price);
        }

        return paymentLogRepository.save(paymentLog);
    }

    private Integer payMock() {
        // 실제 모듈은 연결 안하고 오직 테스트를 위한 메서드
        // 이 프로젝트의 목적은 실제 결제를 개발하는게 아니라
        // 결제가 성공했을 때, 실패 했을 때의 이벤트를
        // 보내고 받고 실패했을 때 이벤트를 어떻게 처리할지에 대한 공부이다
        // random 생성기로 0,1,2이면 실패 아니면 성공으로 간주한다
        // 만약에 결제시스템을 연결한다면 여기서 연결해서 결과를 넘겨주면 된다
        return new Random().nextInt(10);
    }

    @Transactional
    private PaymentRetry saveRetryCount(PaymentLog paymentLog, Integer price) {
        return paymentRetryRepository.save(
            PaymentRetry.builder()
                .retryCount(0)
                .userId(paymentLog.getUserId())
                .productId(paymentLog.getProductId())
                .orderId(paymentLog.getOrderId())
                .price(price)
                .quantity(paymentLog.getQuantity())
                .build());
    }

}
