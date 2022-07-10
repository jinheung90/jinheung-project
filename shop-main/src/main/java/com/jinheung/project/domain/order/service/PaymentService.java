package com.jinheung.project.domain.order.service;


import com.jinheung.project.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.jinheung.project.errorHandling.errorEnums.GlobalErrorCode;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
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
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    @Value("${pay.iamport.rest-key}")
    private String restKey;
    @Value("${pay.iamport.rest-secret}")
    private String secretKey;

    private IamportClient iamportClient;

    @PostConstruct
    public void initImportClient() {
        iamportClient = new IamportClient(restKey, secretKey);
    }

    @Transactional
    public Payment verifyPayment(Long userId, Long productId,String impUid,  Integer quantity, Integer price) {
        try {
            IamportResponse<Payment> paymentResponse = iamportClient.paymentByImpUid(impUid);
            Payment payment = paymentResponse.getResponse();
            return payment;
        } catch (IamportResponseException e) {

            switch(e.getHttpStatusCode()) {
                case 401 :
                    //TODO : 401 Unauthorized

                    break;
                case 404 :
                    //TODO : imp_123412341234 에 해당되는 거래내역이 존재하지 않음

                    break;
                case 500 :
                    //TODO : 서버 응답 오류

                    break;
            }
        } catch (IOException e) {

        }
        return null;
    }

    public void payCancel(String impUid, Integer price) {
        try {
            iamportClient.cancelPaymentByImpUid(
                new CancelData(impUid, true, BigDecimal.valueOf(price)));
        } catch (IamportResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
