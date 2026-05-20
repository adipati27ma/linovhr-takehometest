package com.lawencon.linovhr.exception;

import lombok.*;

@Getter
public class BaseBusinessException extends RuntimeException {
    private String appCode;
    private String errorCode;

    public BaseBusinessException() {
    }

    public BaseBusinessException(String message) {
        super(message);
    }

    public BaseBusinessException(String appCode, String errorCode, String message) {
        super(message);
        this.appCode = appCode;
        this.errorCode = errorCode;
    }

}