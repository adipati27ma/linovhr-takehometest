package com.lawencon.linovhr.config;

import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

@Data
@Component
@ConfigurationProperties("jwt")
public class JwtConfig {
    private String whitelistUrl;
}
