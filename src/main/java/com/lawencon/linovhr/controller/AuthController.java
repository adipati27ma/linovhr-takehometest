package com.lawencon.linovhr.controller;

import com.lawencon.linovhr.exception.*;
import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.service.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final ApiExceptionHandler apiExceptionHandler;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    @PostMapping("/login")
    public BaseResponse<Object> loginUser(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        return authService.loginUser(loginRequest);
    }
}
