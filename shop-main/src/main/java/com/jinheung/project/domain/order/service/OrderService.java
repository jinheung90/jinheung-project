package com.jinheung.project.domain.order.service;

import com.jinheung.project.domain.order.mongo.doc.OrderEvent;
import com.jinheung.project.domain.order.mongo.doc.PaymentLog;
import com.jinheung.project.domain.order.mongo.repository.OrderEventRepository;

import com.jinheung.project.domain.order.mongo.repository.PaymentLogRepository;
import com.jinheung.project.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.project.errorHandling.errorEnums.GlobalErrorCode;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    @Value("${pay.iamport.rest-key}")
    private String restKey;
    @Value("${pay.iamport.rest-secret}")
    private String secretKey;

    private IamportClient iamportClient;

    private final OrderEventRepository orderEventRepository;
    private final PaymentLogRepository paymentLogRepository;
    public OrderEvent saveOrderEvent(Long userId, String productId, String impUid,
                                          Integer quantity, Integer price) {
        return orderEventRepository.save(
            OrderEvent.builder()
                .userId(userId)
                .productId(productId)
                .success(0)

                .impUid(impUid)
                .price(price)
                .stock(quantity).build()
        );
    }

    public OrderEvent saveFailureOrderEvent(String orderId, String reason) {
        OrderEvent orderEvent = orderEventRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeExceptionWithCode(GlobalErrorCode.NOT_EXISTS_ORDER_EVENT));
        orderEvent.setFailure(reason);
        return orderEventRepository.save(orderEvent);
    }

    public PaymentLog savePaymentLog(Long userId, String impUid, String reason, Integer status, String productId) {
        return paymentLogRepository.save(
            PaymentLog.builder()
                .impUid(impUid)
                .status(status)
                .userId(userId)
                .productId(productId)
                .reason(reason)
                .build()
        );
    }


    @PostConstruct
    public void initImportClient() {
        iamportClient = new IamportClient(restKey, secretKey);
    }

    @Transactional
    public Payment verifyPayment(Long userId, String productId,String impUid,  Integer quantity, Integer price) {
        try {
            IamportResponse<Payment> paymentResponse = iamportClient.paymentByImpUid(impUid);
            Payment payment = paymentResponse.getResponse();
            this.saveOrderEvent(userId,productId,impUid,quantity,price);
        } catch (IamportResponseException e) {

            switch(e.getHttpStatusCode()) {
                case 401 :
                    //TODO : 401 Unauthorized
                    savePaymentLog(userId, impUid,e.getLocalizedMessage(), 401, productId);
                    break;
                case 404 :
                    //TODO : imp_123412341234 에 해당되는 거래내역이 존재하지 않음
                    savePaymentLog(userId, impUid,e.getLocalizedMessage(), 404, productId);
                    break;
                case 500 :
                    //TODO : 서버 응답 오류
                    savePaymentLog(userId, impUid,e.getLocalizedMessage(), 500, productId);
                    break;
            }
        } catch (IOException e) {
            savePaymentLog(userId, impUid,e.getLocalizedMessage(), 500, productId);
        }
        return null;
    }
}
