package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity
public class AccumulateSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccumulateSecurityApplication.class, args);
    }

}
