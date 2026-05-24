package com.lawencon.linovhr.service.impl;

import com.lawencon.linovhr.repository.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String employeeCode) throws UsernameNotFoundException {
        return userRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
