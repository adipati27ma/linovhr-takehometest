package com.lawencon.linovhr.exception;

import lombok.*;

@Getter
public class BusinessException extends BaseBusinessException {
    static final String LINOV = "LINOV";

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String appCode, String errorCode, String message) {
        super(appCode, errorCode, message);
    }

    public static BusinessException invalidInput() {
        return new BusinessException("Invalid Input");
    }

    public static BusinessException unauthorized() {
        return new BusinessException("Unauthorized");
    }

    public static BusinessException notFound() {
        return new BusinessException("Not Found");
    }

    public static BusinessException notFound(String item, Object id) {
        return new BusinessException(String.format("%s Not Found: %s", item, id));
    }

    public static BusinessException tokenNotFound() {
        return new BusinessException(LINOV, "AUTH-001", "Token not found");
    }

    public static BusinessException invalidToken() {
        return new BusinessException(LINOV, "AUTH-002", "Invalid Token");
    }

    public static BusinessException requestExpired() {
        return new BusinessException(LINOV, "AUTH-003", "Expired Token");
    }

    public static BusinessException generalError() {
        return new BusinessException(LINOV, "ERR-01", "GENERAL ERROR");
    }
}
