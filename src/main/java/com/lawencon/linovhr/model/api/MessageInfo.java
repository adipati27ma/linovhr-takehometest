package com.lawencon.linovhr.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@JsonInclude(Include.NON_NULL)
@Data
public class MessageInfo {
    private String code;
    private String title;
    private String message;
}
