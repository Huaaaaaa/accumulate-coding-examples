package com.accumulate.coding.middle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.sql.DataSourceDefinition;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AccumulateCodingMiddleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccumulateCodingMiddleApplication.class, args);
    }

}
