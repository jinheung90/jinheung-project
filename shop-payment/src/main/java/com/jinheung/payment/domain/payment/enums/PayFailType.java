package com.jinheung.payment.domain.payment.enums;

import com.jinheung.payment.domain.payment.jpa.entity.PaymentLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayFailType {
    LACK_OF_BALANCE( 0),
    PAYMENT_AGENCY_API_ERROR(1),
    SUCCESS(2);

    private int value;

    public static PayFailType getState(int value) {
        for (PayFailType p : PayFailType.values()
             ) {
            if(p.getValue() == value) {
                return p;
            }
        }

        return null;
    }
}
