package com.lawencon.linovhr.service.impl;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.service.*;
import com.lawencon.linovhr.validator.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaveServiceImpl implements LeaveService {
    public BaseResponse<Object> createLeave(CreateLeaveRequest createLeaveRequest) {
        LeaveRequestValidator.validateLeaveRequestDate(createLeaveRequest.getStartDate(), createLeaveRequest.getEndDate());

        return BaseResponse.createSuccessResponse("Leave created successfully!");
    }
}