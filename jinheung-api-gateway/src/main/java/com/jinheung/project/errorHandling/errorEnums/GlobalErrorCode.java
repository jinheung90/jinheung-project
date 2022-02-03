package com.jinheung.project.errorHandling.errorEnums;

import com.jinheung.project.errorHandling.errorEnums.errorEnums.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum GlobalErrorCode implements IErrorCode {
    BAD_REQUEST("bad request", 400),
    SEND_FAIL("not connected child server", 500),
    ASYNC_FAIL("ASYNC_FAIL", 500),
    SQL_ERROR("SQL_ERROR", 500),
    IO_ERROR("io error", 500),
    ALREADY_USER_NIC("already exist nickname",  400),
    EXIST_EMAIL("already exist email",  400),
    ALREADY_WITHDRAWAL("already withdrawal",  400),
    ALREADY_EXIST_USER("already exist user", 400),
    DUPLICATE_EMAIL("email duplicate",  400),
    NOT_EXISTS_REGION("not exists region", 400),
    EXIST_NICKNAME("nickname is duplicate", 400),
    NOT_EXISTS_USER("not exists user", 403),
    NOT_ALLOW_USER("not allow user", 403),
    NOT_VALID_TOKEN("not valid access token", 401),
    NOT_EXISTS_MENTOR("not exist mentor but required", 400),
    NOT_EXISTS_RESERVATION_WITH_SAME_MENTEE_AND_ID("not exists reservation id and mentee", 400),
    NOT_EXISTS_RESERVATION_WITH_SAME_MENTOR_AND_ID("not exists reservation id and mentor", 400),
    RESERVATION_NOT_ALLOW_DATE_PERIOD("not allowed date period", 400),
    RESERVATION_NOT_ALLOW_DATE_AVAILABLE_DAY("not allowed date day term", 400),
    ALREADY_RESERVATION("already reservation", 400),
    ALREADY_EXISTS_DAY_OF_WEEK_SCHEDULE("already exists default schedule", 400),
    NOT_ALLOW_GET_SCHEDULE_OVER_LIMIT_DAYS("when mentor schedule get but days is too many", 400),
    EMAIL_AUTH_NOT_EXIST_DOMAIN("not exists domain", 400),
    EMAIL_AUTH_NOT_MATCH_NUMBER("not match num", 400),
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
