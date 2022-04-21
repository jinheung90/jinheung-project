package com.jinheung.project.errorHandling.errorEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Getter
public enum GlobalErrorCode implements IErrorCode {
    BAD_REQUEST("bad request", 400),
    SEND_FAIL("not connected child server", 500),
    ASYNC_FAIL("ASYNC_FAIL", 500),
    SQL_ERROR("SQL_ERROR", 500),
    IO_ERROR("io error", 500),
    NOT_ALLOW_GRANTED_USER("not allow granted",403),
    UNAUTHORIZED_USER("unauthorized user", 401),
    NOT_EXISTS_USER("not exists user", 400),
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
