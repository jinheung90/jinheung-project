package com.jinheung.project.errorHandling.errorEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum NotExistsCode implements IErrorCode {

    NOT_EXIST_USER("유저가 없습니다 (id를 못찾는다)",  404, "N1001"),
    NOT_EXIST_CHILD("자녀가 없습니다 (id를 못찾는다)",  404, "N1002"),
    NOT_EXIST_IMAGE("이미지가 없습니다 (id를 못찾는다)",  404, "N1003"),
    NOT_EXIST_ENUM_VALUE("enum을 못찾는다",  404, "N1004");
    private String message;
    private int status;
    private String code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
