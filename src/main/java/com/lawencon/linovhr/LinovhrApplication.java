package com.lawencon.linovhr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.*;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.lawencon.linovhr.repository"})
@EntityScan(basePackages = {"com.lawencon.linovhr.model.entity"})
@EnableJpaAuditing
public class LinovhrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinovhrApplication.class, args);
	}

}
