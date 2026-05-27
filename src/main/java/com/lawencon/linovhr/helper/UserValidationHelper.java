package com.lawencon.linovhr.helper;

import com.lawencon.linovhr.model.entity.*;
import jakarta.servlet.http.*;
import org.springframework.stereotype.*;

@Component
public class UserValidationHelper {
    private UserValidationHelper() {}

    /**
     * Get authenticated user data from request attribute.
     *
     * @param request HTTP servlet request containing user attribute
     * @return authenticated user, or null if user is not available
     */
    public static User getUser(HttpServletRequest request) {
        return (User) request.getAttribute("user");
    }
}
