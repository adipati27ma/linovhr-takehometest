package com.lawencon.linovhr.controller;

import com.lawencon.linovhr.model.api.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
@Slf4j
public class LeaveController {

    @GetMapping("/test")
    public BaseResponse<Object> getLeave() {
        return BaseResponse.createSuccessResponse("Leave API is working!");
    }

    @GetMapping("/cantest")
    public BaseResponse<Object> getCanTest() {
        return BaseResponse.createSuccessResponse("Test API is working without LOGIN!");
    }
}
