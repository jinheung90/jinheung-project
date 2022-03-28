package com.jinheung.project.errorHandling.errorEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ErrorCode
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AuthErrorCode implements IErrorCode {

    EXIST_USER_ANOTHER_SOCIAL("소셜로그인이 중복입니다", 401, "L1002"),
    NOT_VALID_TOKEN("토큰이 유효하지 않습니다", 401, "L1003"),
    NOT_CHECK_AGREEMENT("필수 동의사항을 모두 체크하세요", 402, "L1004"),
    ALREADY_EXIST_USER_BY_PHONE("해당 휴대폰으로 가입한 유저가 있습니다", 409, "L1005"),
    ALREADY_EXIST_USER_BY_EMAIL("해당 이메일로 가입한 유저가 있습니다", 409, "L1006"),
    PHONE_AUTH_NUM_IS_NULL("휴대폰 인증번호가 만료되었습니다", 401, "L1007"),
    PHONE_AUTH_NUM_IS_NOT_MATCH("휴대폰 인증번호가 다릅니다", 401, "L1008");

    private String message;
    private int status;
    private String code;

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return this.message;
    }
    @Override
    public String getCode() {
        // TODO Auto-generated method stub
        return this.code;
    }
    @Override
    public int getStatus() {
        // TODO Auto-generated method stub
        return this.status;
    }


}
