package com.accumulate.coding.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages = "com.accumulate.coding")
@EnableWebFlux
@EnableScheduling
public class AccumulateCoding {

    public static void main(String[] args) {
        SpringApplication.run(AccumulateCoding.class, args);
    }

}
