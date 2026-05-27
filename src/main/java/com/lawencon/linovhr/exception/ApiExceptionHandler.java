package com.lawencon.linovhr.exception;

import com.lawencon.linovhr.helper.*;
import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.entity.*;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> handleBusinessException(BusinessException businessException, Locale locale, HttpServletRequest request) {
        log.warn("[{}] Failed to process request. code: {},  msg: {}",
                getMethodName(businessException), businessException.getErrorCode(), businessException.getMessage());

        String errorCode = businessException.getErrorCode();
        String title = businessException.getErrorCode();

        String message = businessException.getMessage();

        String methodName = getMethodName(businessException);
        User user = UserValidationHelper.getUser(request);
        log.warn(
                "[LINOVHR, {}] userId: {}, {}",
                methodName, user == null ? "un-authenticated" : user.getId(),
                businessException.getMessage()
        );

        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setMessage(message);
        baseResponse.setStatus(1);
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(errorCode);
        messageInfo.setTitle(title);
        messageInfo.setMessage(message);
        baseResponse.setMessageInfo(messageInfo);
        return baseResponse;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(BadCredentialsException.class)
    public BaseResponse<Object> handleBadCredentials(BadCredentialsException ex, HttpServletRequest request) {
        log.error("[{}] Bad credentials error: {}", getMethodName(ex), ex.getMessage(), ex);

        String message = "User or password is wrong";
        String errorCode = "AUTH-002";

        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setMessage(message);
        baseResponse.setStatus(1);
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(errorCode);
        messageInfo.setTitle(errorCode);
        messageInfo.setMessage(message);
        baseResponse.setMessageInfo(messageInfo);
        return baseResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleGeneralException(Exception ex, HttpServletRequest request) {
        log.error("[{}] Unexpected error: {}", getMethodName(ex, false), ex.getMessage(), ex);
        return BaseResponse.createFailedResponse(999);
    }

    private static String getMethodName(Exception e) {
        return getMethodName(e, true);
    }

    private static String getMethodName(Exception e, boolean isCustomException) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (!isCustomException)
            return stackTrace[0].getMethodName();

        if (stackTrace.length > 1)
            return stackTrace[1].getMethodName();
        if (stackTrace.length > 0)
            return stackTrace[0].getMethodName();

        return "Unknown Method";
    }
}
