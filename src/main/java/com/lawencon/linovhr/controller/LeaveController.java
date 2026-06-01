package com.lawencon.linovhr.controller;

import com.lawencon.linovhr.model.api.*;
import com.lawencon.linovhr.model.api.request.*;
import com.lawencon.linovhr.service.*;
import jakarta.servlet.http.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
@Slf4j
public class LeaveController {
    private final LeaveService leaveService;

    @GetMapping("/test")
    public BaseResponse<Object> getLeave() {
        return BaseResponse.createSuccessResponse("Leave API is working!");
    }

    @GetMapping("/cantest")
    public BaseResponse<Object> getCanTest() {
        return BaseResponse.createSuccessResponse("Test API is working without LOGIN!");
    }

    @PostMapping()
    public BaseResponse<Object> createLeave(@RequestBody CreateLeaveRequest createLeaveRequest, HttpServletRequest httpServletRequest) {
        return leaveService.createLeave(createLeaveRequest);
    }
}
