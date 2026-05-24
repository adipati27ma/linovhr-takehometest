package com.lawencon.linovhr.controller;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    @PostMapping("/login")
    public BaseResponse<Object> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }
}
