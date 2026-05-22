package com.lawencon.linovhr.config;

import org.springframework.boot.flyway.autoconfigure.*;
import org.springframework.context.annotation.*;

@Configuration
@Profile("fresh-migrate")
public class FlywayConfig {
    @Bean
    public FlywayMigrationStrategy cleanMigrationStrategy() {
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}

