package com.jinheung.payment.domain.payment.kafka;

import com.google.gson.Gson;
import com.jinheung.common.dto.kafka.KafkaEventDto;
import com.jinheung.common.dto.payment.PaymentKafkaDto;
import com.jinheung.common.event.MsaEvents;

import com.jinheung.payment.domain.payment.enums.PayFailType;
import com.jinheung.payment.domain.payment.jpa.entity.PaymentLog;
import com.jinheung.payment.domain.payment.jpa.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.jinheung.common.event.MsaEvents.KAFKA_TOPIC_PRODUCT_STOCK_REDUCE_FAILURE;

@Component
@RequiredArgsConstructor
public class PaymentStockKafkaListener {

    private final PaymentService paymentService;
    private final KafkaTemplate<String, KafkaEventDto> template;

    @KafkaListener(id = "payment", topics = MsaEvents.KAFKA_TOPIC_PAYMENT)
    public void payment(@Payload KafkaEventDto dto) {
        PaymentKafkaDto paymentKafkaDto = new Gson().fromJson(dto.getJsonData(), PaymentKafkaDto.class);
        PaymentLog paymentLog = paymentService.pay(
            paymentKafkaDto.getProductId(),
            paymentKafkaDto.getQuantity(),
            paymentKafkaDto.getOrderId(),
            Long.valueOf(dto.getUserId()),
            paymentKafkaDto.getPrice()
        );
        if(paymentLog.getPayFailType().equals(PayFailType.LACK_OF_BALANCE)) {
            // 잔액 부족이면 취소시키고 재고 감소도 취소시킨다
            template.send("", new KafkaEventDto(

            ));
        }
    }


}
