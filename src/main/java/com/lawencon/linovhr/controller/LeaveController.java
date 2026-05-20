package com.lawencon.linovhr.controller;

import com.lawencon.linovhr.exception.*;
import com.lawencon.linovhr.model.api.*;
import io.swagger.v3.oas.annotations.*;
import jakarta.servlet.http.*;
import jakarta.validation.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
@Slf4j
public class LeaveController {

    @GetMapping("/test")
    public BaseResponse<Object> getLeave() {
        return BaseResponse.createSuccessResponse("Leave API is working!");
    }
}
