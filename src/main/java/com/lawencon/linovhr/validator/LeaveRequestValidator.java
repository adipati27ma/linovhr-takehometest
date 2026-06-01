package com.lawencon.linovhr.validator;

import com.lawencon.linovhr.exception.*;
import com.lawencon.linovhr.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import java.time.LocalDate;

@Component
@Slf4j
@RequiredArgsConstructor
public class LeaveRequestValidator {
    private final UserRepository userRepository;

    /**
     * Validates the start and end dates for a new leave request.
     * @param startDate start date in format yyyy-MM-dd
     * @param endDate end date in format yyyy-MM-dd
     */
    public static void validateLeaveRequestDate(String startDate, String endDate) {
        if (startDate == null || startDate.isBlank() || endDate == null || endDate.isBlank()) {
            throw BusinessException.invalidDateNull();
        }
        // enforce strict format yyyy-MM-dd
        String pattern = "\\d{4}-\\d{2}-\\d{2}";
        if (!startDate.matches(pattern) || !endDate.matches(pattern)) {
            throw BusinessException.invalidDateFormat();
        }

        LocalDate s = LocalDate.parse(startDate);
        LocalDate e = LocalDate.parse(endDate);
        if (s.isAfter(e)) {
            throw BusinessException.invalidDate();
        }
    }
}
