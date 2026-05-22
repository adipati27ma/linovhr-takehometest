package com.lawencon.linovhr.model.api.request;

import lombok.*;

@Data
public class CreateLeaveRequest {
    private String startDate;
    private String endDate;
    private String reason;
}
