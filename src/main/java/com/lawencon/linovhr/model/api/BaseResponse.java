package com.lawencon.linovhr.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lawencon.linovhr.exception.*;
import lombok.*;

import java.util.*;

@JsonInclude(Include.NON_NULL)
@Data
public class BaseResponse<T> {
    private Integer status;
    private String message;
    private T data;
    private MessageInfo messageInfo;
    private Object exception;

    public static <T> BaseResponse<T> createSuccessResponse() {
        BaseResponse<T> response = new BaseResponse<>();
        response.setStatus(0);
        response.setMessage("ok");
        return response;
    }

    public static BaseResponse<Object> createSuccessResponse(Object data) {
        BaseResponse<Object> response = createSuccessResponse();
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> buildSuccessResponse(T data) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setStatus(0);
        response.setMessage("ok");
        response.setData(data);
        return response;
    }

    public static BaseResponse<Object> createSuccessResponseWithSinglePayload(String key, Object payloadData) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, payloadData);
        return createSuccessResponse(data);
    }

    public static <T> BaseResponse<T> createFailedResponse(Integer statusCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setStatus(statusCode);
        response.setMessage("Terjadi kesalahan pada sistem");
        return response;
    }

    public static <T> BaseResponse<T> createFailedResponse(Integer statusCode, String message) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setStatus(statusCode);
        response.setMessage(message);
        return response;
    }

    public static <T> BaseResponse<T> createFailedResponse(Integer statusCode, String message, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setStatus(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}