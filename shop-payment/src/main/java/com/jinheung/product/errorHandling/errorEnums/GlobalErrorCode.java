package com.jinheung.product.errorHandling.errorEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum GlobalErrorCode implements IErrorCode {
    BAD_REQUEST("bad request", 400),
    NOT_EXISTS_PRODUCT("not exists product", 400),
    LACK_OF_BALANCE("lack of balance", 403), // 토스에서 잔액 부족을 403을 때리더라
    PAYMENT_AGENCY_API_ERROR("payment api error",500)
    ;
    private String message;
    private int status;
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return this.message;
    }
    @Override
    public String getCode() {
        // TODO Auto-generated method stub
        return this.toString();
    }
    @Override
    public int getStatus() {
        // TODO Auto-generated method stub
        return this.status;
    }
}
