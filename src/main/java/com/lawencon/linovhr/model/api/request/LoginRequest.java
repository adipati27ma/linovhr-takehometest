package com.lawencon.linovhr.model.api.request;

import lombok.*;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
