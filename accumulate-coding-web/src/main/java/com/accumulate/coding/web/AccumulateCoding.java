package com.accumulate.coding.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages = "com.accumulate.coding")
@MapperScan("com.accumulate.coding.tool.mapper")
@EnableWebFlux
@EnableScheduling
public class AccumulateCoding {

    public static void main(String[] args) {
        SpringApplication.run(AccumulateCoding.class, args);
    }

}
