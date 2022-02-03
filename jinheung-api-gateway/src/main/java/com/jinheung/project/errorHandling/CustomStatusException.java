package com.jinheung.project.errorHandling;

import com.jinheung.project.errorHandling.errorEnums.IErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomStatusException extends ResponseStatusException {

    private IErrorCode errorCode;
    private String message;


    public CustomStatusException(HttpStatus status, String message) {
        super(status, message);
    }

    public CustomStatusException(HttpStatus status, String message, Throwable e) {
        super(status, message, e);
    }

    public CustomStatusException(IErrorCode errorCode) {
        super(HttpStatus.resolve(errorCode.getStatus()), errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public CustomStatusException(IErrorCode errorCode,String message) {
        super(HttpStatus.resolve(errorCode.getStatus()), message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getCode() {
        return this.errorCode.getCode();
    }
    public IErrorCode getErrorCode() {
        return  this.getErrorCode();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.resolve(this.errorCode.getStatus());
    }

}
