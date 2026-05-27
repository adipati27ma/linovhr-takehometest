package com.lawencon.linovhr.service;

import com.lawencon.linovhr.model.entity.User;
import org.springframework.security.core.userdetails.*;

public interface UserService {
    User findUserByUsername(String employeeCode) throws UsernameNotFoundException;
}
