package com.accumulate.coding.middle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MiddleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddleApplication.class, args);
    }

}
