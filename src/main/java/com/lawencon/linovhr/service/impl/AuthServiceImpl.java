package com.lawencon.linovhr.service.impl;

import com.lawencon.linovhr.exception.*;
import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.model.api.response.*;
import com.lawencon.linovhr.model.entity.*;
import com.lawencon.linovhr.repository.*;
import com.lawencon.linovhr.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public BaseResponse<Object> loginUser(LoginRequest loginRequest) {
        // authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmployeeCode(),
                        loginRequest.getPassword()
                )
        );

        User user = userRepository.findByEmployeeCode(loginRequest.getEmployeeCode()).orElseThrow(BusinessException::userNotFound);
        String token = jwtService.generateToken(user);
        LoginResponse loginResponseDTO = LoginResponse.builder()
                .accessToken(token)
                .expiresIn(jwtService.getJwtExpirations())
                .build();
        return BaseResponse.createSuccessResponse(loginResponseDTO);
    }
}
