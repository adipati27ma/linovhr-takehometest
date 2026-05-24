package com.lawencon.linovhr.service.impl;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.model.api.response.*;
import com.lawencon.linovhr.model.entity.*;
import com.lawencon.linovhr.repository.*;
import com.lawencon.linovhr.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public BaseResponse<Object> loginUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmployeeCode(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        User user = userRepository.findByEmployeeCode(loginRequest.getEmployeeCode()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String token = jwtService.generateToken(user);
        LoginResponse loginResponseDTO = LoginResponse.builder()
                .accessToken(token)
                .expiresIn(jwtService.getJwtExpirations())
                .build();
        return BaseResponse.createSuccessResponse(loginResponseDTO);
    }
}
