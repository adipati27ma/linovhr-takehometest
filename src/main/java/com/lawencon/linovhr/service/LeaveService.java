package com.lawencon.linovhr.service;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;

public interface LeaveService {
        BaseResponse<Object> createLeave(CreateLeaveRequest createLeaveRequest);
}
