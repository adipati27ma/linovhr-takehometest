package com.lawencon.linovhr.service.impl;

import com.lawencon.linovhr.exception.*;
import com.lawencon.linovhr.model.entity.User;
import com.lawencon.linovhr.repository.*;
import com.lawencon.linovhr.service.*;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String employeeCode) throws UsernameNotFoundException {
        return userRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(BusinessException::userNotFound);
    }

    /**
     * Duplicate method from {@link UserDetailsServiceImpl#loadUserByUsername(String) loadUserByUsername}
     * needed for returning {@link User} entity.
     */
    public User findUserByUsername(String employeeCode) throws UsernameNotFoundException {
        return userRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(BusinessException::userNotFound);
    }
}
