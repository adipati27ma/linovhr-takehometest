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

//    @PostMapping
//    public BaseResponse<Object> submitOrder(HttpServletRequest request, @RequestBody @Valid RequestPSBSalesDto psbSalesDto) {
//        try {
//            User user = UserValidationHelper.validateUserAndMenuEligibility(request, DigiposConstants.ROLE_FMC, digiposConfig.getPsbMenuId());
//            return null;
//        } catch (BusinessException e) {
//            log.warn("[submitOrder] error: ", e);
//            return apiExceptionHandler.handleBusinessException(e, Locale.forLanguageTag("id"), request);
//        } catch (Exception ex) {
//            log.error("[submitOrder] error: ", ex);
//            return BaseResponse.createFailedResponse(999);
//        }
//    }
//
//    @GetMapping("/inquiry/validation")
//    @Operation(summary = "API for inquiry validation")
//    public BaseResponse<Object> getInquiryValidation(
//            HttpServletRequest request,
//            @RequestParam("sessionId") String sessionId
//    ) {
//        try {
//            User user = UserValidationHelper.validateUserAndMenuEligibility(request, DigiposConstants.ROLE_FMC, digiposConfig.getPsbMenuId());
//            log.info("[getInquiryValidation] processing cek status verify email,userid: {}, sessionId: {}", user.getUserId(), sessionId);
//            return psbInquiryValidationService.getStatusVerifyEmail(sessionId);
//        } catch (BusinessException ex) {
//            log.warn("[getInquiryValidation] error: {}", ex.getMessage());
//            return apiExceptionHandler.handleBusinessException(ex, Locale.forLanguageTag("id"), request);
//        } catch (Exception e) {
//            log.error("[getInquiryValidation] error: ", e);
//            return BaseResponse.createFailedResponse(999);
//        }
//    }
}
