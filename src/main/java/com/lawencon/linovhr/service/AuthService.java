package com.lawencon.linovhr.service;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;

public interface AuthService {
    BaseResponse<Object> loginUser(LoginRequest loginRequest);
}
